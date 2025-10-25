package ar.edu.uade.progra2.grupo2.parte1.ejercicio10;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imple.Pila;
import imple.Conjunto;
import tda.PilaTDA;
import tda.DiccionarioSimpleTDA;
import tda.ConjuntoTDA;

public class FrecuenciaElementosPilaTest {

    private PilaTDA pila;

    @BeforeEach
    void setUp() {
        this.pila = new Pila();
        this.pila.inicializarPila();
    }

    @Test
    void testSinRepetidos() {
        this.pila.apilar(1);
        this.pila.apilar(2);
        this.pila.apilar(3);
        this.pila.apilar(4);

        DiccionarioSimpleTDA resultado = FrecuenciaElementosPila.obtener(this.pila);
        ConjuntoTDA claves = resultado.claves();

        assertAll("Verificar frecuencias correctas sin repetidos",
            () -> assertEquals(4, this.contarElementos(claves), "Debe haber 4 claves distintas"),
            () -> assertEquals(1, resultado.recuperar(1), "La frecuencia de 1 debe ser 1"),
            () -> assertEquals(1, resultado.recuperar(2), "La frecuencia de 2 debe ser 1"),
            () -> assertEquals(1, resultado.recuperar(3), "La frecuencia de 3 debe ser 1"),
            () -> assertEquals(1, resultado.recuperar(4), "La frecuencia de 4 debe ser 1")
        );

        assertAll("Verificar que la pila no fue modificada",
            () -> assertEquals(4, this.pila.tope(), "El tope original debe seguir siendo 4"),
            () -> { this.pila.desapilar(); assertEquals(3, this.pila.tope(), "Después de desapilar 4, debe ser 3"); },
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope(), "Después de desapilar 3, debe ser 2"); },
            () -> { this.pila.desapilar(); assertEquals(1, this.pila.tope(), "Después de desapilar 2, debe ser 1"); }
        );
    }

    @Test
    void testConRepetidos() {
        this.pila.apilar(1);
        this.pila.apilar(2);
        this.pila.apilar(1);
        this.pila.apilar(3);
        this.pila.apilar(2);
        this.pila.apilar(1);

        DiccionarioSimpleTDA resultado = FrecuenciaElementosPila.obtener(this.pila);

        assertAll("Verificar frecuencias correctas con repetidos",
            () -> assertEquals(3, resultado.recuperar(1), "La frecuencia de 1 debe ser 3"),
            () -> assertEquals(2, resultado.recuperar(2), "La frecuencia de 2 debe ser 2"),
            () -> assertEquals(1, resultado.recuperar(3), "La frecuencia de 3 debe ser 1"),
            () -> assertEquals(3, this.contarElementos(resultado.claves()), "Debe haber 3 claves distintas")
        );

        assertAll("Verificar que la pila no fue modificada",
            () -> assertEquals(1, this.pila.tope(), "El tope original debe seguir siendo 1"),
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope(), "Después de desapilar 1, debe ser 2"); },
            () -> { this.pila.desapilar(); assertEquals(3, this.pila.tope(), "Después de desapilar 2, debe ser 3"); },
            () -> { this.pila.desapilar(); assertEquals(1, this.pila.tope(), "Después de desapilar 3, debe ser 1"); },
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope(), "Después de desapilar 1, debe ser 2"); },
            () -> { this.pila.desapilar(); assertEquals(1, this.pila.tope(), "Después de desapilar 2, debe ser 1"); }
        );
    }

    @Test
    void testTodosIguales() {
        this.pila.apilar(5);
        this.pila.apilar(5);
        this.pila.apilar(5);
        this.pila.apilar(5);

        DiccionarioSimpleTDA resultado = FrecuenciaElementosPila.obtener(this.pila);

        assertAll("Verificar frecuencia cuando todos son iguales",
            () -> assertEquals(1, this.contarElementos(resultado.claves()), "Debe haber solo 1 clave"),
            () -> assertEquals(4, resultado.recuperar(5), "La frecuencia de 5 debe ser 4")
        );

        assertAll("Verificar que la pila no fue modificada",
            () -> assertEquals(5, this.pila.tope(), "El tope original debe seguir siendo 5"),
            () -> { this.pila.desapilar(); assertEquals(5, this.pila.tope(), "Después de desapilar 5, debe seguir siendo 5"); },
            () -> { this.pila.desapilar(); assertEquals(5, this.pila.tope(), "Después de desapilar 5, debe seguir siendo 5"); },
            () -> { this.pila.desapilar(); assertEquals(5, this.pila.tope(), "Después de desapilar 5, debe seguir siendo 5"); }
        );
    }

    @Test
    void testPilaUnElemento() {
        this.pila.apilar(9);

        DiccionarioSimpleTDA resultado = FrecuenciaElementosPila.obtener(this.pila);

        assertAll("Verificar frecuencia con un solo elemento",
            () -> assertEquals(1, this.contarElementos(resultado.claves()), "Debe haber solo 1 clave"),
            () -> assertEquals(1, resultado.recuperar(9), "La frecuencia de 9 debe ser 1")
        );

        assertEquals(9, this.pila.tope(), "El único elemento de la pila debe seguir siendo 9");
    }

    @Test
    void testPilaVacia() {
        DiccionarioSimpleTDA resultado = FrecuenciaElementosPila.obtener(this.pila);
        assertTrue(resultado.claves().conjuntoVacio(), "Si la pila está vacía, no debe haber claves");
        assertTrue(this.pila.pilaVacia(), "La pila debe seguir vacía después del cálculo");
    }

    private int contarElementos(ConjuntoTDA conjunto) {
        ConjuntoTDA aux = new Conjunto();
        aux.inicializarConjunto();
        int contador = 0;

        while (!conjunto.conjuntoVacio()) {
            int elem = conjunto.elegir();
            conjunto.sacar(elem);
            aux.agregar(elem);
            contador++;
        }

        while (!aux.conjuntoVacio()) {
            int elem = aux.elegir();
            aux.sacar(elem);
            conjunto.agregar(elem);
        }

        return contador;
    }
}
