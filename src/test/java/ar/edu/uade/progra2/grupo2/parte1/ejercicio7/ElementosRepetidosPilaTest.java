package ar.edu.uade.progra2.grupo2.parte1.ejercicio7;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imple.Pila;
import tda.PilaTDA;
import tda.ConjuntoTDA;

public class ElementosRepetidosPilaTest {

    private PilaTDA pila;

    @BeforeEach
    void setUp() {
        this.pila = new Pila();
        this.pila.inicializarPila();
    }

    @Test
    void testSinElementosRepetidos() {
        this.pila.apilar(1);
        this.pila.apilar(2);
        this.pila.apilar(3);
        this.pila.apilar(4);

        ConjuntoTDA resultado = ElementosRepetidosPila.obtener(this.pila);

        assertTrue(resultado.conjuntoVacio(), "No debería haber elementos repetidos");

        assertAll("La pila debe conservar su orden original",
            () -> assertEquals(4, this.pila.tope(), "El primer elemento del tope debería ser 4"),
            () -> { this.pila.desapilar(); assertEquals(3, this.pila.tope(), "Después de desapilar 4, el tope debería ser 3"); },
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope(), "Después de desapilar 3, el tope debería ser 2"); },
            () -> { this.pila.desapilar(); assertEquals(1, this.pila.tope(), "Después de desapilar 2, el tope debería ser 1"); }
        );
    }

    @Test
    void testConElementosRepetidos() {
        this.pila.apilar(1);
        this.pila.apilar(2);
        this.pila.apilar(3);
        this.pila.apilar(2);
        this.pila.apilar(1);

        ConjuntoTDA resultado = ElementosRepetidosPila.obtener(this.pila);

        assertTrue(resultado.pertenece(1), "El conjunto de repetidos debería contener 1");
        assertTrue(resultado.pertenece(2), "El conjunto de repetidos debería contener 2");
        assertFalse(resultado.pertenece(3), "El conjunto de repetidos no debería contener 3");

        assertAll("La pila debe conservar su orden original",
            () -> assertEquals(1, this.pila.tope(), "El primer elemento del tope debería ser 1"),
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope(), "Después de desapilar 1, el tope debería ser 2"); },
            () -> { this.pila.desapilar(); assertEquals(3, this.pila.tope(), "Después de desapilar 2, el tope debería ser 3"); },
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope(), "Después de desapilar 3, el tope debería ser 2"); },
            () -> { this.pila.desapilar(); assertEquals(1, this.pila.tope(), "Después de desapilar 2, el tope debería ser 1"); }
        );
    }

    @Test
    void testTodosRepetidos() {
        this.pila.apilar(5);
        this.pila.apilar(5);
        this.pila.apilar(5);
        this.pila.apilar(5);

        ConjuntoTDA resultado = ElementosRepetidosPila.obtener(this.pila);

        assertTrue(resultado.pertenece(5), "El conjunto de repetidos debería contener 5");

        assertAll("La pila debe conservar su orden original",
            () -> assertEquals(5, this.pila.tope(), "El primer elemento del tope debería ser 5"),
            () -> { this.pila.desapilar(); assertEquals(5, this.pila.tope(), "Después de desapilar 5, el tope debería seguir siendo 5"); },
            () -> { this.pila.desapilar(); assertEquals(5, this.pila.tope(), "Después de desapilar 5, el tope debería seguir siendo 5"); },
            () -> { this.pila.desapilar(); assertEquals(5, this.pila.tope(), "Después de desapilar 5, el tope debería seguir siendo 5"); }
        );
    }

    @Test
    void testPilaConUnSoloElemento() {
        this.pila.apilar(10);

        ConjuntoTDA resultado = ElementosRepetidosPila.obtener(this.pila);

        assertTrue(resultado.conjuntoVacio(), "No debería haber repetidos con un solo elemento");
        assertEquals(10, this.pila.tope(), "El único elemento de la pila debería ser 10");
    }

    @Test
    void testPilaVacia() {
        ConjuntoTDA resultado = ElementosRepetidosPila.obtener(this.pila);

        assertTrue(resultado.conjuntoVacio(), "La pila vacía no debería tener elementos repetidos");
        assertTrue(this.pila.pilaVacia(), "La pila debe permanecer vacía después del cálculo");
    }

}
