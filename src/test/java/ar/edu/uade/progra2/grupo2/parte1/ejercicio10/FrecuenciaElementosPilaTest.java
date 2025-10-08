package ar.edu.uade.progra2.grupo2.parte1.ejercicio10;

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
        assertEquals(4, this.contarElementos(claves));
        assertEquals(1, resultado.recuperar(1));
        assertEquals(1, resultado.recuperar(2));
        assertEquals(1, resultado.recuperar(3));
        assertEquals(1, resultado.recuperar(4));
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

        assertEquals(3, resultado.recuperar(1));
        assertEquals(2, resultado.recuperar(2));
        assertEquals(1, resultado.recuperar(3));
        assertEquals(3, this.contarElementos(resultado.claves()));
    }

    @Test
    void testTodosIguales() {
        this.pila.apilar(5);
        this.pila.apilar(5);
        this.pila.apilar(5);
        this.pila.apilar(5);

        DiccionarioSimpleTDA resultado = FrecuenciaElementosPila.obtener(this.pila);

        assertEquals(1, this.contarElementos(resultado.claves()));
        assertEquals(4, resultado.recuperar(5));
    }

    @Test
    void testPilaUnElemento() {
        this.pila.apilar(9);

        DiccionarioSimpleTDA resultado = FrecuenciaElementosPila.obtener(this.pila);

        assertEquals(1, this.contarElementos(resultado.claves()));
        assertEquals(1, resultado.recuperar(9));
    }

    @Test
    void testPilaVacia() {
        DiccionarioSimpleTDA resultado = FrecuenciaElementosPila.obtener(this.pila);
        assertTrue(resultado.claves().conjuntoVacio());
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
