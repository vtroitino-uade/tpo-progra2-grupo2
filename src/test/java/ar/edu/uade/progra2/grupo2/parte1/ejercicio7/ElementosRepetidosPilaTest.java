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

        assertTrue(resultado.conjuntoVacio());

        assertAll(
            () -> assertEquals(4, this.pila.tope()),
            () -> { this.pila.desapilar(); assertEquals(3, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(1, this.pila.tope()); }
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

        assertTrue(resultado.pertenece(1));
        assertTrue(resultado.pertenece(2));
        assertFalse(resultado.pertenece(3));

        assertAll(
            () -> assertEquals(1, this.pila.tope()),
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(3, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(1, this.pila.tope()); }
        );
    }

    @Test
    void testTodosRepetidos() {
        this.pila.apilar(5);
        this.pila.apilar(5);
        this.pila.apilar(5);
        this.pila.apilar(5);

        ConjuntoTDA resultado = ElementosRepetidosPila.obtener(this.pila);

        assertTrue(resultado.pertenece(5));

        assertAll(
            () -> assertEquals(5, this.pila.tope()),
            () -> { this.pila.desapilar(); assertEquals(5, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(5, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(5, this.pila.tope()); }
        );
    }

    @Test
    void testPilaConUnSoloElemento() {
        this.pila.apilar(10);

        ConjuntoTDA resultado = ElementosRepetidosPila.obtener(this.pila);

        assertTrue(resultado.conjuntoVacio());

        assertEquals(10, this.pila.tope());
    }

    @Test
    void testPilaVacia() {
        ConjuntoTDA resultado = ElementosRepetidosPila.obtener(this.pila);

        assertTrue(resultado.conjuntoVacio());
        assertTrue(this.pila.pilaVacia());
    }

}
