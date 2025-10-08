package ar.edu.uade.progra2.grupo2.parte1.ejercicio6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imple.Pila;
import tda.PilaTDA;

public class PorcentajeElementosParesPilaTest {

    private PilaTDA pila;

    @BeforeEach
    void setUp() {
        pila = new Pila();
        pila.inicializarPila();
    }

    @Test
    void testMitadPares() {
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(4);
        float resultado = PorcentajeElementosParesPila.calcular(pila);
        assertEquals(50.0f, resultado, 0.01);
    }

    @Test
    void testTodosPares() {
        pila.apilar(2);
        pila.apilar(4);
        pila.apilar(6);
        float resultado = PorcentajeElementosParesPila.calcular(pila);
        assertEquals(100.0f, resultado, 0.01);
    }

    @Test
    void testNingunoPar() {
        pila.apilar(1);
        pila.apilar(3);
        pila.apilar(5);
        float resultado = PorcentajeElementosParesPila.calcular(pila);
        assertEquals(0.0f, resultado, 0.01);
    }

    @Test
    void testPilaVacia() {
        float resultado = PorcentajeElementosParesPila.calcular(pila);
        assertEquals(0.0f, resultado, 0.01);
    }
}
