package ar.edu.uade.progra2.grupo2.parte1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imple.ABB;
import tda.ABBTDA;

public class CantidadHojasParesABBTest {

    private ABBTDA arbol;

    @BeforeEach
    void setUp() {
        this.arbol = new ABB();
        this.arbol.inicializarArbol();
    }

    @Test
    void testArbolVacio() {
        int resultado = CantidadHojasParesABB.calcular(this.arbol);
        assertEquals(0, resultado);
    }

    @Test
    void testSoloUnNodoPar() {
        this.arbol.agregarElem(2);
        int resultado = CantidadHojasParesABB.calcular(this.arbol);
        assertEquals(1, resultado);
    }

    @Test
    void testSoloUnNodoImpar() {
        this.arbol.agregarElem(3);
        int resultado = CantidadHojasParesABB.calcular(this.arbol);
        assertEquals(0, resultado);
    }

    @Test
    void testArbolSoloPares() {
        this.arbol.agregarElem(8);
        this.arbol.agregarElem(4);
        this.arbol.agregarElem(12);
        this.arbol.agregarElem(2);
        this.arbol.agregarElem(6);
        this.arbol.agregarElem(10);
        this.arbol.agregarElem(14);

        int resultado = CantidadHojasParesABB.calcular(this.arbol);
        assertEquals(4, resultado); // hojas: 2, 6, 10, 14
    }

    @Test
    void testArbolMixto() {
        this.arbol.agregarElem(5);
        this.arbol.agregarElem(3);
        this.arbol.agregarElem(8);
        this.arbol.agregarElem(2);
        this.arbol.agregarElem(4);
        this.arbol.agregarElem(7);
        this.arbol.agregarElem(10);

        int resultado = CantidadHojasParesABB.calcular(this.arbol);
        assertEquals(3, resultado); // hojas pares: 2, 4 y 10
    }

    @Test
    void testArbolDesbalanceadoIzquierda() {
        this.arbol.agregarElem(10);
        this.arbol.agregarElem(8);
        this.arbol.agregarElem(6);
        this.arbol.agregarElem(4);
        this.arbol.agregarElem(2);

        int resultado = CantidadHojasParesABB.calcular(this.arbol);
        assertEquals(1, resultado); // hoja final: 2
    }

    @Test
    void testArbolDesbalanceadoDerecha() {
        this.arbol.agregarElem(1);
        this.arbol.agregarElem(3);
        this.arbol.agregarElem(5);
        this.arbol.agregarElem(7);
        this.arbol.agregarElem(9);

        int resultado = CantidadHojasParesABB.calcular(this.arbol);
        assertEquals(0, resultado); // todas impares
    }

    @Test
    void testArbolMixtoConHojasAmbasParidades() {
        this.arbol.agregarElem(6);
        this.arbol.agregarElem(3);
        this.arbol.agregarElem(9);
        this.arbol.agregarElem(2);
        this.arbol.agregarElem(4);
        this.arbol.agregarElem(8);
        this.arbol.agregarElem(11);

        int resultado = CantidadHojasParesABB.calcular(this.arbol);
        assertEquals(3, resultado); // hojas pares: 2, 4 y 8
    }
}
