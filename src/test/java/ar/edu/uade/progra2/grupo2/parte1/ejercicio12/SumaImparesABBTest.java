package ar.edu.uade.progra2.grupo2.parte1.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imple.ABB;
import tda.ABBTDA;

public class SumaImparesABBTest {

    private ABBTDA arbol;

    @BeforeEach
    void setUp() {
        this.arbol = new ABB();
        this.arbol.inicializarArbol();
    }

    @Test
    void testArbolVacio() {
        int resultado = SumaImparesABB.calcular(this.arbol);
        assertEquals(0, resultado);
    }

    @Test
    void testSoloElementosPares() {
        this.arbol.agregarElem(2);
        this.arbol.agregarElem(4);
        this.arbol.agregarElem(6);
        this.arbol.agregarElem(8);

        int resultado = SumaImparesABB.calcular(this.arbol);
        assertEquals(0, resultado);
    }

    @Test
    void testSoloElementosImpares() {
        this.arbol.agregarElem(1);
        this.arbol.agregarElem(3);
        this.arbol.agregarElem(5);
        this.arbol.agregarElem(7);

        int resultado = SumaImparesABB.calcular(this.arbol);
        assertEquals(16, resultado); // 1+3+5+7
    }

    @Test
    void testMixtoParesEImpares() {
        this.arbol.agregarElem(5);
        this.arbol.agregarElem(3);
        this.arbol.agregarElem(8);
        this.arbol.agregarElem(2);
        this.arbol.agregarElem(4);
        this.arbol.agregarElem(7);
        this.arbol.agregarElem(10);

        int resultado = SumaImparesABB.calcular(this.arbol);
        assertEquals(15, resultado); // 3 + 5 + 7
    }

    @Test
    void testUnSoloElementoImpar() {
        this.arbol.agregarElem(9);

        int resultado = SumaImparesABB.calcular(this.arbol);
        assertEquals(9, resultado);
    }

    @Test
    void testUnSoloElementoPar() {
        this.arbol.agregarElem(8);

        int resultado = SumaImparesABB.calcular(this.arbol);
        assertEquals(0, resultado);
    }

    @Test
    void testArbolDesbalanceado() {
        this.arbol.agregarElem(10);
        this.arbol.agregarElem(9);
        this.arbol.agregarElem(8);
        this.arbol.agregarElem(7);
        this.arbol.agregarElem(6);
        this.arbol.agregarElem(5);

        int resultado = SumaImparesABB.calcular(this.arbol);
        assertEquals(21, resultado); // 9 + 7 + 5
    }
}
