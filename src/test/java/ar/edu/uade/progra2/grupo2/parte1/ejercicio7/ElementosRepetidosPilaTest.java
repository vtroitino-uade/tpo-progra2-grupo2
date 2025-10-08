package ar.edu.uade.progra2.grupo2.parte1.ejercicio7;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imple.Pila;
import imple.Conjunto;
import tda.PilaTDA;
import tda.ConjuntoTDA;

public class ElementosRepetidosPilaTest {

    private PilaTDA pila;

    @BeforeEach
    void setUp() {
        pila = new Pila();
        pila.inicializarPila();
    }

    @Test
    void testSinElementosRepetidos() {
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(4);

        ConjuntoTDA resultado = ElementosRepetidosPila.obtener(pila);

        assertTrue(resultado.conjuntoVacio());
    }

    @Test
    void testConElementosRepetidos() {
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(2);
        pila.apilar(1);

        ConjuntoTDA resultado = ElementosRepetidosPila.obtener(pila);

        assertTrue(resultado.pertenece(1));
        assertTrue(resultado.pertenece(2));
        assertFalse(resultado.pertenece(3));
    }

    @Test
    void testTodosRepetidos() {
        pila.apilar(5);
        pila.apilar(5);
        pila.apilar(5);
        pila.apilar(5);

        ConjuntoTDA resultado = ElementosRepetidosPila.obtener(pila);

        assertTrue(resultado.pertenece(5));
        assertEquals(1, this.contarElementos(resultado));
    }

    @Test
    void testPilaConUnSoloElemento() {
        pila.apilar(10);

        ConjuntoTDA resultado = ElementosRepetidosPila.obtener(pila);

        assertTrue(resultado.conjuntoVacio());
    }

    @Test
    void testPilaVacia() {
        ConjuntoTDA resultado = ElementosRepetidosPila.obtener(pila);

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
