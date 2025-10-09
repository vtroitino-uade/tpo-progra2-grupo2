package ar.edu.uade.progra2.grupo2.parte1.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertAll;
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

        assertEquals(0, resultado,
            "La suma de impares de un árbol vacío debe ser 0");
    }

    @Test
    void testSoloElementosPares() {
        this.arbol.agregarElem(2);
        this.arbol.agregarElem(4);
        this.arbol.agregarElem(6);
        this.arbol.agregarElem(8);

        int resultado = SumaImparesABB.calcular(this.arbol);

        assertEquals(0, resultado,
            "Si todos los elementos son pares, la suma debe ser 0");
    }

    @Test
    void testSoloElementosImpares() {
        this.arbol.agregarElem(1);
        this.arbol.agregarElem(3);
        this.arbol.agregarElem(5);
        this.arbol.agregarElem(7);

        int resultado = SumaImparesABB.calcular(this.arbol);

        assertEquals(16, resultado,
            "La suma debe ser 1+3+5+7 = 16");
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

        assertEquals(15, resultado,
            "La suma debe incluir solo los impares (3+5+7=15)");
    }

    @Test
    void testUnSoloElementoImpar() {
        this.arbol.agregarElem(9);

        int resultado = SumaImparesABB.calcular(this.arbol);

        assertEquals(9, resultado,
            "Si el único elemento es impar (9), la suma debe ser 9");
    }

    @Test
    void testUnSoloElementoPar() {
        this.arbol.agregarElem(8);

        int resultado = SumaImparesABB.calcular(this.arbol);

        assertEquals(0, resultado,
            "Si el único elemento es par (8), la suma debe ser 0");
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

        assertEquals(21, resultado,
            "La suma debe ser 9+7+5 = 21 para un árbol desbalanceado hacia la izquierda");
    }

    @Test
    void testVariosCasosAgrupados() {
        ABBTDA arbol1 = new ABB();
        arbol1.inicializarArbol();
        arbol1.agregarElem(1);
        arbol1.agregarElem(2);
        arbol1.agregarElem(3);

        ABBTDA arbol2 = new ABB();
        arbol2.inicializarArbol();
        arbol2.agregarElem(2);
        arbol2.agregarElem(4);
        arbol2.agregarElem(6);

        ABBTDA arbol3 = new ABB();
        arbol3.inicializarArbol();
        arbol3.agregarElem(7);

        assertAll("Verificar múltiples escenarios de suma de impares",
            () -> assertEquals(4, SumaImparesABB.calcular(arbol1),
                    "1+3 = 4 en un árbol con impares y pares"),
            () -> assertEquals(0, SumaImparesABB.calcular(arbol2),
                    "Si todos los elementos son pares, la suma debe ser 0"),
            () -> assertEquals(7, SumaImparesABB.calcular(arbol3),
                    "Con un solo nodo impar, la suma debe ser su propio valor")
        );
    }
}
