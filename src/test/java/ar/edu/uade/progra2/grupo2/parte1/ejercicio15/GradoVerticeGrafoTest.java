package ar.edu.uade.progra2.grupo2.parte1.ejercicio15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imple.Grafo;
import tda.GrafoTDA;

public class GradoVerticeGrafoTest {

    private GrafoTDA grafo;

    @BeforeEach
    void setUp() {
        this.grafo = new Grafo();
        this.grafo.inicializarGrafo();

        this.grafo.agregarVertice(1);
        this.grafo.agregarVertice(2);
        this.grafo.agregarVertice(3);
        this.grafo.agregarVertice(4);
        this.grafo.agregarVertice(5);
    }

    @Test
    void testVerticeSinAristas() {
        int resultado = GradoVerticeGrafo.calcular(this.grafo, 1);
        assertEquals(0, resultado);
    }

    @Test
    void testSoloAristasSalientes() {
        this.grafo.agregarArista(1, 2, 1);
        this.grafo.agregarArista(1, 3, 1);
        this.grafo.agregarArista(1, 4, 1);

        int resultado = GradoVerticeGrafo.calcular(this.grafo, 1);
        assertEquals(3, resultado); // 3 salen, 0 llegan
    }

    @Test
    void testSoloAristasEntrantes() {
        this.grafo.agregarArista(2, 1, 1);
        this.grafo.agregarArista(3, 1, 1);
        this.grafo.agregarArista(4, 1, 1);

        int resultado = GradoVerticeGrafo.calcular(this.grafo, 1);
        assertEquals(-3, resultado); // 0 salen, 3 llegan
    }

    @Test
    void testAristasMixtas() {
        this.grafo.agregarArista(1, 2, 1);
        this.grafo.agregarArista(1, 3, 1);
        this.grafo.agregarArista(4, 1, 1);
        this.grafo.agregarArista(5, 1, 1);

        int resultado = GradoVerticeGrafo.calcular(this.grafo, 1);
        assertEquals(0, resultado); // 2 salen, 2 llegan
    }

    @Test
    void testVerticeConUnaSalidaYUnaEntrada() {
        this.grafo.agregarArista(1, 2, 1);
        this.grafo.agregarArista(3, 1, 1);

        int resultado = GradoVerticeGrafo.calcular(this.grafo, 1);
        assertEquals(0, resultado); // 1 sale, 1 llega
    }

    @Test
    void testVariosVerticesConDistintosGrados() {
        this.grafo.agregarArista(1, 2, 1);
        this.grafo.agregarArista(1, 3, 1);
        this.grafo.agregarArista(2, 3, 1);
        this.grafo.agregarArista(3, 4, 1);
        this.grafo.agregarArista(4, 5, 1);
        this.grafo.agregarArista(5, 1, 1);

        assertEquals(1, GradoVerticeGrafo.calcular(this.grafo, 1));  // 2 salen, 1 llega
        assertEquals(0, GradoVerticeGrafo.calcular(this.grafo, 2));  // 1 sale, 1 llega
        assertEquals(1, GradoVerticeGrafo.calcular(this.grafo, 3));  // 2 salen, 1 llega
        assertEquals(0, GradoVerticeGrafo.calcular(this.grafo, 4));  // 1 sale, 1 llega
        assertEquals(-1, GradoVerticeGrafo.calcular(this.grafo, 5)); // 1 sale, 2 llegan
    }

    @Test
    void testVerticeInexistente() {
        this.grafo.agregarArista(1, 2, 1);
        int resultado = GradoVerticeGrafo.calcular(this.grafo, 99);
        assertEquals(0, resultado);
    }

    @Test
    void testGrafoSinAristas() {
        int resultado = GradoVerticeGrafo.calcular(this.grafo, 3);
        assertEquals(0, resultado);
    }
}
