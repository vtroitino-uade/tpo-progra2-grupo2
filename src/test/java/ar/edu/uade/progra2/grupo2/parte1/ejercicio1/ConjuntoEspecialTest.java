package ar.edu.uade.progra2.grupo2.parte1.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.uade.progra2.grupo2.parte1.ejercicio1.implementacion.ConjuntoEspecial;
import ar.edu.uade.progra2.grupo2.parte1.ejercicio1.interfaz.ConjuntoEspecialTDA;

public class ConjuntoEspecialTest {

    private ConjuntoEspecialTDA conjunto;

    @BeforeEach
    void setUp() {
        this.conjunto = new ConjuntoEspecial();
        this.conjunto.inicializarConjunto();
    }

    @Test
    void testTipoDeImplementacion() {
        assertTrue(this.conjunto instanceof ConjuntoEspecial);
    }

    @Test
    void testAgregarElementoNuevo() {
        int valorAgregado = 1;
        ConjuntoEspecialTDA.Respuesta respuesta = this.conjunto.agregar(valorAgregado);
        assertFalse(respuesta.error);
        assertEquals(valorAgregado, respuesta.rta);
    }

    @Test
    void testAgregarElementoRepetido() {
        int valorAgregado = 10;
        this.conjunto.agregar(valorAgregado);
        ConjuntoEspecialTDA.Respuesta respuesta = this.conjunto.agregar(valorAgregado);
        assertTrue(respuesta.error);
        assertEquals(valorAgregado, respuesta.rta);
    }

    @Test
    void testSacarElementoSatisfactorio() {
        int valorARemover = 1;
        this.conjunto.agregar(valorARemover);
        ConjuntoEspecialTDA.Respuesta respuesta = this.conjunto.sacar(valorARemover);
        assertFalse(respuesta.error);
        assertEquals(valorARemover, respuesta.rta);
    }

    @Test
    void testSacarElementoError() {
        int valorARemover = 1;
        ConjuntoEspecialTDA.Respuesta respuesta = this.conjunto.sacar(valorARemover);
        assertTrue(respuesta.error);
        assertEquals(valorARemover, respuesta.rta);
    }

    @Test
    void testElegirElemento() {
        int valorElegido = 1;
        this.conjunto.agregar(valorElegido);
        ConjuntoEspecialTDA.Respuesta respuesta = this.conjunto.elegir();
        assertFalse(respuesta.error);
        assertEquals(valorElegido, respuesta.rta);
    }

    @Test
    void testPerteneceElementoSatisfactorio() {
        this.conjunto.agregar(1);
        this.conjunto.agregar(5);
        this.conjunto.agregar(7);
        boolean respuesta = this.conjunto.pertenece(5);
        assertTrue(respuesta);
    }

    @Test
    void testPerteneceElementoError() {
        this.conjunto.agregar(1);
        this.conjunto.agregar(5);
        this.conjunto.agregar(7);
        boolean respuesta = this.conjunto.pertenece(9);
        assertFalse(respuesta);
    }

    @Test
    void testConjuntoVacioSatisfactorio() {
        boolean respuesta = this.conjunto.conjuntoVacio();
        assertTrue(respuesta);
    }

    @Test
    void testConjuntoVacioError() {
        this.conjunto.agregar(1);
        this.conjunto.agregar(5);
        this.conjunto.agregar(7);
        boolean respuesta = this.conjunto.conjuntoVacio();
        assertFalse(respuesta);
    }

}
