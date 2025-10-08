package ar.edu.uade.progra2.grupo2.parte1.ejercicio9;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imple.Pila;
import imple.Cola;
import imple.Conjunto;
import tda.PilaTDA;
import tda.ColaTDA;
import tda.ConjuntoTDA;

public class ElementosComunesPilaYColaTest {

    private PilaTDA pila;
    private ColaTDA cola;

    @BeforeEach
    void setUp() {
        this.pila = new Pila();
        this.pila.inicializarPila();

        this.cola = new Cola();
        this.cola.inicializarCola();
    }

    @Test
    void testElementosComunesBasico() {
        this.pila.apilar(1);
        this.pila.apilar(2);
        this.pila.apilar(3);
        this.pila.apilar(4);

        this.cola.acolar(3);
        this.cola.acolar(4);
        this.cola.acolar(5);
        this.cola.acolar(6);

        ConjuntoTDA resultado = ElementosComunesPilaYCola.obtener(this.pila, this.cola);

        assertTrue(resultado.pertenece(3));
        assertTrue(resultado.pertenece(4));
        assertFalse(resultado.pertenece(1));
        assertFalse(resultado.pertenece(5));
    }

    @Test
    void testSinElementosComunes() {
        this.pila.apilar(1);
        this.pila.apilar(2);
        this.pila.apilar(3);

        this.cola.acolar(4);
        this.cola.acolar(5);
        this.cola.acolar(6);

        ConjuntoTDA resultado = ElementosComunesPilaYCola.obtener(this.pila, this.cola);

        assertTrue(resultado.conjuntoVacio());
    }

    @Test
    void testConDuplicadosEnColaYPila() {
        this.pila.apilar(2);
        this.pila.apilar(2);
        this.pila.apilar(3);
        this.pila.apilar(3);
        this.pila.apilar(4);

        this.cola.acolar(1);
        this.cola.acolar(2);
        this.cola.acolar(2);
        this.cola.acolar(3);
        this.cola.acolar(3);
        this.cola.acolar(5);

        ConjuntoTDA resultado = ElementosComunesPilaYCola.obtener(this.pila, this.cola);

        assertTrue(resultado.pertenece(2));
        assertTrue(resultado.pertenece(3));
        assertFalse(resultado.pertenece(1));
        assertFalse(resultado.pertenece(4));
        assertEquals(2, this.contarElementos(resultado));
    }

    @Test
    void testPilaVacia() {
        this.cola.acolar(1);
        this.cola.acolar(2);
        this.cola.acolar(3);

        ConjuntoTDA resultado = ElementosComunesPilaYCola.obtener(this.pila, this.cola);

        assertTrue(resultado.conjuntoVacio());
    }

    @Test
    void testColaVacia() {
        this.pila.apilar(1);
        this.pila.apilar(2);
        this.pila.apilar(3);

        ConjuntoTDA resultado = ElementosComunesPilaYCola.obtener(this.pila, this.cola);

        assertTrue(resultado.conjuntoVacio());
    }

    @Test
    void testAmbasVacias() {
        ConjuntoTDA resultado = ElementosComunesPilaYCola.obtener(this.pila, this.cola);
        assertTrue(resultado.conjuntoVacio());
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
