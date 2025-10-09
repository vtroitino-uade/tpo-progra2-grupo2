package ar.edu.uade.progra2.grupo2.parte1.ejercicio9;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imple.Pila;
import imple.Cola;
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

        assertAll("Verificar elementos comunes entre pila y cola",
            () -> assertTrue(resultado.pertenece(3), "El conjunto debería contener el 3"),
            () -> assertTrue(resultado.pertenece(4), "El conjunto debería contener el 4"),
            () -> assertFalse(resultado.pertenece(1), "El conjunto no debería contener el 1"),
            () -> assertFalse(resultado.pertenece(5), "El conjunto no debería contener el 5")
        );

        assertAll("La pila original debe conservar su orden",
            () -> assertEquals(4, this.pila.tope()),
            () -> { this.pila.desapilar(); assertEquals(3, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(1, this.pila.tope()); }
        );

        assertAll("La cola original debe conservar su orden",
            () -> assertEquals(3, this.cola.primero()),
            () -> { this.cola.desacolar(); assertEquals(4, this.cola.primero()); },
            () -> { this.cola.desacolar(); assertEquals(5, this.cola.primero()); },
            () -> { this.cola.desacolar(); assertEquals(6, this.cola.primero()); }
        );
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

        assertTrue(resultado.conjuntoVacio(), "Si no hay elementos en común, el conjunto debe estar vacío");

        assertAll("La pila original debe conservar su orden",
            () -> assertEquals(3, this.pila.tope()),
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(1, this.pila.tope()); }
        );

        assertAll("La cola original debe conservar su orden",
            () -> assertEquals(4, this.cola.primero()),
            () -> { this.cola.desacolar(); assertEquals(5, this.cola.primero()); },
            () -> { this.cola.desacolar(); assertEquals(6, this.cola.primero()); }
        );
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

        assertAll("Verificar elementos comunes cuando hay duplicados",
            () -> assertTrue(resultado.pertenece(2), "El conjunto debería contener el 2"),
            () -> assertTrue(resultado.pertenece(3), "El conjunto debería contener el 3"),
            () -> assertFalse(resultado.pertenece(1), "El conjunto no debería contener el 1"),
            () -> assertFalse(resultado.pertenece(4), "El conjunto no debería contener el 4")
        );

        assertAll("La pila original debe conservar su orden",
            () -> assertEquals(4, this.pila.tope()),
            () -> { this.pila.desapilar(); assertEquals(3, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(3, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope()); }
        );

        assertAll("La cola original debe conservar su orden",
            () -> assertEquals(1, this.cola.primero()),
            () -> { this.cola.desacolar(); assertEquals(2, this.cola.primero()); },
            () -> { this.cola.desacolar(); assertEquals(2, this.cola.primero()); },
            () -> { this.cola.desacolar(); assertEquals(3, this.cola.primero()); },
            () -> { this.cola.desacolar(); assertEquals(3, this.cola.primero()); },
            () -> { this.cola.desacolar(); assertEquals(5, this.cola.primero()); }
        );
    }

    @Test
    void testPilaVacia() {
        this.cola.acolar(1);
        this.cola.acolar(2);
        this.cola.acolar(3);

        ConjuntoTDA resultado = ElementosComunesPilaYCola.obtener(this.pila, this.cola);

        assertTrue(resultado.conjuntoVacio(), "Si la pila está vacía, no puede haber elementos en común");

        assertTrue(this.pila.pilaVacia(), "La pila original debe conservarse");

        assertAll("La cola original debe conservar su orden",
            () -> assertEquals(1, this.cola.primero()),
            () -> { this.cola.desacolar(); assertEquals(2, this.cola.primero()); },
            () -> { this.cola.desacolar(); assertEquals(3, this.cola.primero()); }
        );
    }

    @Test
    void testColaVacia() {
        this.pila.apilar(1);
        this.pila.apilar(2);
        this.pila.apilar(3);

        ConjuntoTDA resultado = ElementosComunesPilaYCola.obtener(this.pila, this.cola);

        assertTrue(resultado.conjuntoVacio(), "Si la cola está vacía, no puede haber elementos en común");

        assertAll("La pila original debe conservar su orden",
            () -> assertEquals(3, this.pila.tope()),
            () -> { this.pila.desapilar(); assertEquals(2, this.pila.tope()); },
            () -> { this.pila.desapilar(); assertEquals(1, this.pila.tope()); }
        );

        assertTrue(this.pila.pilaVacia(), "La cola original debe conservarse");
    }

    @Test
    void testAmbasVacias() {
        ConjuntoTDA resultado = ElementosComunesPilaYCola.obtener(this.pila, this.cola);
        assertTrue(resultado.conjuntoVacio(), "Si pila y cola están vacías, el conjunto debe estar vacío");
        assertTrue(this.pila.pilaVacia(), "La pila original debe conservarse");
        assertTrue(this.pila.pilaVacia(), "La cola original debe conservarse");
    }

}
