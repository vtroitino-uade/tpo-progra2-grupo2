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

        assertEquals(50.0f, resultado, 0.01, "El porcentaje debe ser 50% cuando la mitad de los elementos son pares");

        assertAll("La pila debe conservar su orden original después del cálculo",
            () -> assertEquals(4, this.pila.tope(), "El primer elemento del tope debería ser 4"),
            () -> { this.pila.desapilar(); assertEquals(3, this.pila.tope(), "Después de desapilar 4, el tope debería ser 3"); },
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope(), "Después de desapilar 3, el tope debería ser 2"); },
            () -> { this.pila.desapilar(); assertEquals(1, this.pila.tope(), "Después de desapilar 2, el tope debería ser 1"); }
        );
    }

    @Test
    void testTodosPares() {
        this.pila.apilar(2);
        this.pila.apilar(4);
        this.pila.apilar(6);

        float resultado = PorcentajeElementosParesPila.calcular(this.pila);

        assertEquals(100.0f, resultado, 0.01, "El porcentaje debe ser 100% cuando todos los elementos son pares");

        assertAll("La pila debe conservar su orden original después del cálculo",
            () -> assertEquals(6, this.pila.tope(), "El primer elemento del tope debería ser 6"),
            () -> { this.pila.desapilar(); assertEquals(4, this.pila.tope(), "Después de desapilar 6, el tope debería ser 4"); },
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope(), "Después de desapilar 4, el tope debería ser 2"); }
        );
    }

    @Test
    void testNingunoPar() {
        this.pila.apilar(1);
        this.pila.apilar(3);
        this.pila.apilar(5);

        float resultado = PorcentajeElementosParesPila.calcular(this.pila);

        assertEquals(0.0f, resultado, 0.01, "El porcentaje debe ser 0% cuando no hay elementos pares");

        assertAll("La pila debe conservar su orden original después del cálculo",
            () -> assertEquals(5, this.pila.tope(), "El primer elemento del tope debería ser 5"),
            () -> { this.pila.desapilar(); assertEquals(3, this.pila.tope(), "Después de desapilar 5, el tope debería ser 3"); },
            () -> { this.pila.desapilar(); assertEquals(1, this.pila.tope(), "Después de desapilar 3, el tope debería ser 1"); }
        );
    }

    @Test
    void testPilaVacia() {
        float resultado = PorcentajeElementosParesPila.calcular(this.pila);

        assertEquals(0.0f, resultado, 0.01, "El porcentaje debe ser 0% cuando la pila está vacía");
        assertTrue(this.pila.pilaVacia(), "La pila debe seguir vacía después de calcular");
    }
}
