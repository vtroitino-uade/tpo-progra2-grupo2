package ar.edu.uade.progra2.grupo2.parte1.ejercicio11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imple.DiccionarioMultiple;
import imple.Cola;
import tda.DiccionarioMultipleTDA;
import tda.ColaTDA;

public class ValoresUnicosDiccionarioTest {

    private DiccionarioMultipleTDA diccionario;

    @BeforeEach
    void setUp() {
        this.diccionario = new DiccionarioMultiple();
        this.diccionario.inicializarDiccionario();
    }

    @Test
    void testDiccionarioVacio() {
        ColaTDA resultado = ValoresUnicosDiccionario.obtener(this.diccionario);
        assertEquals(0, this.contarElementos(resultado));
    }

    @Test
    void testSinValoresRepetidos() {
        this.diccionario.agregar(1, 10);
        this.diccionario.agregar(2, 20);
        this.diccionario.agregar(3, 30);

        ColaTDA resultado = ValoresUnicosDiccionario.obtener(this.diccionario);

        assertEquals(3, this.contarElementos(resultado));
        assertTrue(this.colaContiene(resultado, 10));
        assertTrue(this.colaContiene(resultado, 20));
        assertTrue(this.colaContiene(resultado, 30));
    }

    @Test
    void testConValoresRepetidosEntreClaves() {
        this.diccionario.agregar(1, 10);
        this.diccionario.agregar(1, 20);
        this.diccionario.agregar(2, 20);
        this.diccionario.agregar(2, 30);
        this.diccionario.agregar(3, 10);

        ColaTDA resultado = ValoresUnicosDiccionario.obtener(this.diccionario);

        assertEquals(3, this.contarElementos(resultado));
        assertTrue(this.colaContiene(resultado, 10));
        assertTrue(this.colaContiene(resultado, 20));
        assertTrue(this.colaContiene(resultado, 30));
    }

    @Test
    void testTodosValoresRepetidos() {
        this.diccionario.agregar(1, 5);
        this.diccionario.agregar(2, 5);
        this.diccionario.agregar(3, 5);

        ColaTDA resultado = ValoresUnicosDiccionario.obtener(this.diccionario);

        assertEquals(1, this.contarElementos(resultado));
        assertTrue(this.colaContiene(resultado, 5));
    }

    @Test
    void testClavesConMultiplesValores() {
        this.diccionario.agregar(1, 10);
        this.diccionario.agregar(1, 20);
        this.diccionario.agregar(1, 30);
        this.diccionario.agregar(2, 40);
        this.diccionario.agregar(2, 50);

        ColaTDA resultado = ValoresUnicosDiccionario.obtener(this.diccionario);

        assertEquals(5, this.contarElementos(resultado));
        assertTrue(this.colaContiene(resultado, 10));
        assertTrue(this.colaContiene(resultado, 20));
        assertTrue(this.colaContiene(resultado, 30));
        assertTrue(this.colaContiene(resultado, 40));
        assertTrue(this.colaContiene(resultado, 50));
    }

    // --- Helpers ---

    private int contarElementos(ColaTDA cola) {
        ColaTDA aux = new Cola();
        aux.inicializarCola();
        int contador = 0;

        while (!cola.colaVacia()) {
            int elem = cola.primero();
            cola.desacolar();
            aux.acolar(elem);
            contador++;
        }

        while (!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }

        return contador;
    }

    private boolean colaContiene(ColaTDA cola, int valor) {
        ColaTDA aux = new Cola();
        aux.inicializarCola();
        boolean encontrado = false;

        while (!cola.colaVacia()) {
            int elem = cola.primero();
            cola.desacolar();
            aux.acolar(elem);

            if (elem == valor) {
                encontrado = true;
            }
        }

        while (!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }

        return encontrado;
    }
}
