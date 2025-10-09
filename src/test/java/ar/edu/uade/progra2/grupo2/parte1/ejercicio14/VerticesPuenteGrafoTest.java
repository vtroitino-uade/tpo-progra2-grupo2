package ar.edu.uade.progra2.grupo2.parte1.ejercicio14;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imple.Grafo;
import imple.Conjunto;
import tda.GrafoTDA;
import tda.ConjuntoTDA;

public class VerticesPuenteGrafoTest {

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
    void testSinPuentes() {
        this.grafo.agregarArista(1, 2, 1);
        this.grafo.agregarArista(2, 4, 1);
        this.grafo.agregarArista(2, 3, 1);
        this.grafo.agregarArista(3, 5, 1);

        ConjuntoTDA resultado = VerticesPuenteGrafo.obtener(this.grafo, 1, 5);

        assertTrue(resultado.conjuntoVacio());
    }

    @Test
    void testUnSoloPuente() {
        this.grafo.agregarArista(1, 2, 1);
        this.grafo.agregarArista(2, 3, 1);

        ConjuntoTDA resultado = VerticesPuenteGrafo.obtener(this.grafo, 1, 3);

        assertTrue(resultado.pertenece(2));
        assertEquals(1, this.contarElementos(resultado));
    }

    @Test
    void testMultiplesPuentes() {
        this.grafo.agregarArista(1, 2, 1);
        this.grafo.agregarArista(1, 3, 1);
        this.grafo.agregarArista(2, 4, 1);
        this.grafo.agregarArista(3, 4, 1);
        this.grafo.agregarArista(4, 5, 1);

        ConjuntoTDA resultado = VerticesPuenteGrafo.obtener(this.grafo, 1, 4);

        assertTrue(resultado.pertenece(2));
        assertTrue(resultado.pertenece(3));
        assertFalse(resultado.pertenece(4));
        assertEquals(2, this.contarElementos(resultado));
    }

    @Test
    void testPuenteQueTambienTieneCaminoDirecto() {
        this.grafo.agregarArista(1, 2, 1);
        this.grafo.agregarArista(2, 3, 1);
        this.grafo.agregarArista(1, 3, 1); // camino directo

        ConjuntoTDA resultado = VerticesPuenteGrafo.obtener(this.grafo, 1, 3);

        assertTrue(resultado.pertenece(2));
        assertEquals(1, this.contarElementos(resultado));
    }

    @Test
    void testSinAristas() {
        ConjuntoTDA resultado = VerticesPuenteGrafo.obtener(this.grafo, 1, 2);
        assertTrue(resultado.conjuntoVacio());
    }

    @Test
    void testOrigenSinSalidas() {
        this.grafo.agregarArista(2, 3, 1);
        this.grafo.agregarArista(3, 4, 1);

        ConjuntoTDA resultado = VerticesPuenteGrafo.obtener(this.grafo, 1, 4);
        assertTrue(resultado.conjuntoVacio());
    }

    @Test
    void testDestinoInexistente() {
        this.grafo.agregarArista(1, 2, 1);
        this.grafo.agregarArista(2, 3, 1);

        ConjuntoTDA resultado = VerticesPuenteGrafo.obtener(this.grafo, 1, 99);
        assertTrue(resultado.conjuntoVacio());
    }

    @Test
    void testOrigenInexistente() {
        this.grafo.agregarArista(2, 3, 1);
        this.grafo.agregarArista(3, 4, 1);

        ConjuntoTDA resultado = VerticesPuenteGrafo.obtener(this.grafo, 99, 4);
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
