package ar.edu.uade.progra2.grupo2.parte1.ejercicio8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imple.Cola;
import tda.ColaTDA;

public class ColaSinRepetidosTest {

    private ColaTDA cola;

    @BeforeEach
    void setUp() {
        this.cola = new Cola();
        this.cola.inicializarCola();
    }

    @Test
    void testSinRepetidos() {
        this.cola.acolar(1);
        this.cola.acolar(2);
        this.cola.acolar(3);
        this.cola.acolar(4);

        ColaTDA resultado = ColaSinRepetidos.obtener(this.cola);

        assertTrue(this.colasIguales(this.cola, resultado));
    }

    @Test
    void testConRepetidosAlFinal() {
        this.cola.acolar(1);
        this.cola.acolar(2);
        this.cola.acolar(3);
        this.cola.acolar(3);
        this.cola.acolar(3);

        ColaTDA resultado = ColaSinRepetidos.obtener(this.cola);

        assertEquals(3, this.contarElementos(resultado));
        assertTrue(this.contieneEnOrden(resultado, new int[]{1, 2, 3}));
    }

    @Test
    void testConRepetidosIntercalados() {
        this.cola.acolar(1);
        this.cola.acolar(2);
        this.cola.acolar(1);
        this.cola.acolar(3);
        this.cola.acolar(2);

        ColaTDA resultado = ColaSinRepetidos.obtener(this.cola);

        assertEquals(3, this.contarElementos(resultado));
        assertTrue(this.contieneEnOrden(resultado, new int[]{1, 2, 3}));
    }

    @Test
    void testTodosRepetidos() {
        this.cola.acolar(5);
        this.cola.acolar(5);
        this.cola.acolar(5);
        this.cola.acolar(5);

        ColaTDA resultado = ColaSinRepetidos.obtener(this.cola);

        assertEquals(1, this.contarElementos(resultado));
        assertTrue(this.contieneEnOrden(resultado, new int[]{5}));
    }

    @Test
    void testColaConUnSoloElemento() {
       this.cola.acolar(10);

        ColaTDA resultado = ColaSinRepetidos.obtener(this.cola);

        assertEquals(1, this.contarElementos(resultado));
        assertTrue(this.contieneEnOrden(resultado, new int[]{10}));
    }

    @Test
    void testColaVacia() {
        ColaTDA resultado = ColaSinRepetidos.obtener(this.cola);
        assertEquals(0, this.contarElementos(resultado));
    }

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

    private boolean contieneEnOrden(ColaTDA cola, int[] esperados) {
        ColaTDA aux = new Cola();
        aux.inicializarCola();
        int i = 0;

        while (!cola.colaVacia() && i < esperados.length) {
            int valor = cola.primero();
            cola.desacolar();
            aux.acolar(valor);

            if (valor != esperados[i]) {
                restaurar(cola, aux);
                return false;
            }
            i++;
        }

        boolean correcto = (i == esperados.length);

        restaurar(cola, aux);
        return correcto;
    }

    private boolean colasIguales(ColaTDA c1, ColaTDA c2) {
        ColaTDA aux1 = new Cola();
        ColaTDA aux2 = new Cola();
        aux1.inicializarCola();
        aux2.inicializarCola();

        boolean iguales = true;

        while (!c1.colaVacia() && !c2.colaVacia()) {
            int v1 = c1.primero();
            int v2 = c2.primero();

            if (v1 != v2) iguales = false;

            aux1.acolar(v1);
            aux2.acolar(v2);
            c1.desacolar();
            c2.desacolar();
        }

        if (!c1.colaVacia() || !c2.colaVacia()) iguales = false;

        restaurar(c1, aux1);
        restaurar(c2, aux2);
        return iguales;
    }

    private void restaurar(ColaTDA destino, ColaTDA aux) {
        while (!aux.colaVacia()) {
            destino.acolar(aux.primero());
            aux.desacolar();
        }
    }
}
