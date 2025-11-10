package ar.edu.uade.progra2.grupo2.parte1.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.uade.progra2.grupo2.parte1.ejercicio3.implementacion.MultiPila;
import ar.edu.uade.progra2.grupo2.parte1.ejercicio3.interfaz.MultiPilaTDA;
import imple.Pila;
import tda.PilaTDA;

public class MultiPilaTest {

    private MultiPilaTDA multiPila;
    private MultiPilaTDA multiPilaVacia;

    @BeforeEach
    void setUp() {
        PilaTDA valores = new Pila();
        valores.inicializarPila();
        valores.apilar(7);
        valores.apilar(5);
        valores.apilar(3);
        this.multiPila = new MultiPila();
        this.multiPila.inicializarPila();
        this.multiPila.apilar(valores);

        this.multiPilaVacia = new MultiPila();
        this.multiPilaVacia.inicializarPila();
    }

    private boolean pilasIguales(PilaTDA a, PilaTDA b) {
        PilaTDA auxA = new Pila();
        PilaTDA auxB = new Pila();
        auxA.inicializarPila();
        auxB.inicializarPila();

        boolean iguales = true;

        while (!a.pilaVacia() && !b.pilaVacia()) {
            int topeA = a.tope();
            int topeB = b.tope();

            if (topeA != topeB) iguales = false;

            auxA.apilar(topeA);
            auxB.apilar(topeB);
            a.desapilar();
            b.desapilar();
        }

        if (!a.pilaVacia() || !b.pilaVacia()) iguales = false;

        while (!auxA.pilaVacia()) {
            a.apilar(auxA.tope());
            auxA.desapilar();
        }
        while (!auxB.pilaVacia()) {
            b.apilar(auxB.tope());
            auxB.desapilar();
        }

        return iguales;
    }

    @Test
    void testTopePreservaOrdenYSinModificar() {
        PilaTDA copiaAntes = this.multiPila.tope(10);
        PilaTDA resultado = this.multiPila.tope(2);
        PilaTDA resultadoVacio = this.multiPilaVacia.tope(10);

        PilaTDA esperado = new Pila();
        esperado.inicializarPila();
        esperado.apilar(5);
        esperado.apilar(3);
        PilaTDA esperadoVacio = new Pila();
        esperadoVacio.inicializarPila();

        assertTrue(this.pilasIguales(esperado, resultado));
        assertTrue(this.pilasIguales(esperadoVacio, resultadoVacio));
        assertTrue(this.pilasIguales(copiaAntes, this.multiPila.tope(10)));
    }

    @Test
    void testMultiPilaEstaVacia() {
        assertFalse(this.multiPila.pilaVacia());
        assertTrue(this.multiPilaVacia.pilaVacia());
    }

    @Test
    void testApilarValores() {
        PilaTDA nuevosValores = new Pila();
        nuevosValores.inicializarPila();
        nuevosValores.apilar(9);
        nuevosValores.apilar(1);
        this.multiPila.apilar(nuevosValores);

        PilaTDA esperado = new Pila();
        esperado.inicializarPila();
        esperado.apilar(7);
        esperado.apilar(5);
        esperado.apilar(3);
        esperado.apilar(9);
        esperado.apilar(1);

        boolean resultado = this.pilasIguales(esperado, this.multiPila.tope(5));

        assertTrue(resultado);
        assertFalse(nuevosValores.pilaVacia());
    }

    @Test
    void testApilarValoresEnPilaVacia() {
        PilaTDA nuevosValores = new Pila();
        nuevosValores.inicializarPila();
        nuevosValores.apilar(9);
        nuevosValores.apilar(1);
        this.multiPilaVacia.apilar(nuevosValores);

        PilaTDA esperado = new Pila();
        esperado.inicializarPila();
        esperado.apilar(9);
        esperado.apilar(1);

        boolean resultado = this.pilasIguales(esperado, this.multiPilaVacia.tope(2));

        assertTrue(resultado);
        assertFalse(nuevosValores.pilaVacia());
    }

    @Test
    void testApilarVacio() {
        PilaTDA vacio = new Pila();
        vacio.inicializarPila();
        this.multiPila.apilar(vacio);

        PilaTDA esperado = new Pila();
        esperado.inicializarPila();
        esperado.apilar(7);
        esperado.apilar(5);
        esperado.apilar(3);

        boolean resultado = this.pilasIguales(esperado, this.multiPila.tope(3));

        assertTrue(resultado);
        assertTrue(vacio.pilaVacia());
    }

    @Test
    void testDesapilarValores() {
        PilaTDA valoresADesapilar = new Pila();
        valoresADesapilar.inicializarPila();
        valoresADesapilar.apilar(3);
        valoresADesapilar.apilar(5);
        this.multiPila.desapilar(valoresADesapilar);

        PilaTDA esperado = new Pila();
        esperado.inicializarPila();
        esperado.apilar(7);
    
        boolean resultado = this.pilasIguales(esperado, this.multiPila.tope(1));

        assertTrue(resultado);
        assertFalse(valoresADesapilar.pilaVacia());
    }

    @Test
    void testDesapilarValoresEnPilaVacia() {
        PilaTDA valoresADesapilar = new Pila();
        valoresADesapilar.inicializarPila();
        valoresADesapilar.apilar(9);
        valoresADesapilar.apilar(1);
        this.multiPilaVacia.desapilar(valoresADesapilar);

        PilaTDA esperado = new Pila();
        esperado.inicializarPila();

        boolean resultado = this.pilasIguales(esperado, this.multiPilaVacia.tope(2));

        assertTrue(resultado);
        assertFalse(valoresADesapilar.pilaVacia());
    }

    @Test
    void testDesapilarVacio() {
        PilaTDA vacio = new Pila();
        vacio.inicializarPila();
        this.multiPila.desapilar(vacio);

        PilaTDA esperado = new Pila();
        esperado.inicializarPila();
        esperado.apilar(7);
        esperado.apilar(5);
        esperado.apilar(3);

        boolean resultado = this.pilasIguales(esperado, this.multiPila.tope(3));

        assertTrue(resultado);
        assertTrue(vacio.pilaVacia());
    }

}
