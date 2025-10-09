package ar.edu.uade.progra2.grupo2.parte1.ejercicio6;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imple.Pila;
import tda.PilaTDA;

public class PorcentajeElementosParesPilaTest {

    private PilaTDA pila;

    @BeforeEach
    void setUp() {
        this.pila = new Pila();
        this.pila.inicializarPila();
    }

    @Test
    void testMitadPares() {
        this.pila.apilar(1);
        this.pila.apilar(2);
        this.pila.apilar(3);
        this.pila.apilar(4);

        float resultado = PorcentajeElementosParesPila.calcular(this.pila);

        assertEquals(50.0f, resultado, 0.01);

        assertAll(
            () -> assertEquals(4, this.pila.tope()),
            () -> { this.pila.desapilar(); assertEquals(3, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(1, this.pila.tope()); }
        );
    }

    @Test
    void testTodosPares() {
        this.pila.apilar(2);
        this.pila.apilar(4);
        this.pila.apilar(6);

        float resultado = PorcentajeElementosParesPila.calcular(this.pila);

        assertEquals(100.0f, resultado, 0.01);

        assertAll(
            () -> assertEquals(6, this.pila.tope()),
            () -> { this.pila.desapilar(); assertEquals(4, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope()); }
        );
    }

    @Test
    void testNingunoPar() {
        this.pila.apilar(1);
        this.pila.apilar(3);
        this.pila.apilar(5);

        float resultado = PorcentajeElementosParesPila.calcular(this.pila);

        assertEquals(0.0f, resultado, 0.01);

        assertAll(
            () -> assertEquals(5, this.pila.tope()),
            () -> { this.pila.desapilar(); assertEquals(3, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(1, this.pila.tope()); }
        );
    }

    @Test
    void testPilaVacia() {
        float resultado = PorcentajeElementosParesPila.calcular(this.pila);
        assertEquals(0.0f, resultado, 0.01);
        assertTrue(this.pila.pilaVacia());
    }
}
