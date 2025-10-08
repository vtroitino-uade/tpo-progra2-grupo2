package ar.edu.uade.progra2.grupo2.parte1.ejercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConjuntoMamushkaTest {

    private ConjuntoMamushkaTDA conjunto;   

    @BeforeEach
    void setUp() {
        this.conjunto = new ConjuntoMamushka();
        this.conjunto.inicializar();
    }

    @Test
    void testGuardarElementosRepetidos() {
        int valor = 5;
        this.conjunto.guardar(valor);
        this.conjunto.guardar(valor);
        this.conjunto.guardar(valor);

        int cantidad = this.conjunto.perteneceCant(valor);
        assertEquals(3, cantidad);
    }

    @Test
    void testPerteneceCantConVariosValores() {
        this.conjunto.guardar(1);
        this.conjunto.guardar(1);
        this.conjunto.guardar(2);
        this.conjunto.guardar(3);

        assertEquals(2, this.conjunto.perteneceCant(1));
        assertEquals(1, this.conjunto.perteneceCant(2));
        assertEquals(1, this.conjunto.perteneceCant(3));
        assertEquals(0, this.conjunto.perteneceCant(9));
    }

    @Test
    void testSacarUnaOcurrencia() {
        int valor = 10;
        this.conjunto.guardar(valor);
        this.conjunto.guardar(valor);
        this.conjunto.guardar(valor);

        this.conjunto.sacar(valor);

        assertEquals(2, this.conjunto.perteneceCant(valor));
    }

    @Test
    void testConjuntoEstaVacio() {
        assertTrue(this.conjunto.estaVacio());

        this.conjunto.guardar(7);
        assertFalse(this.conjunto.estaVacio());

        this.conjunto.sacar(7);
        assertTrue(this.conjunto.estaVacio());
    }

    @Test
    void testSacarTodasLasOcurrencias() {
        this.conjunto.guardar(8);
        this.conjunto.guardar(8);
        this.conjunto.guardar(8);

        this.conjunto.sacar(8);
        this.conjunto.sacar(8);
        this.conjunto.sacar(8);

        assertEquals(0, this.conjunto.perteneceCant(8));
        assertTrue(this.conjunto.estaVacio());
    }

    @Test
    void testTipoDeImplementacion() {
        assertTrue(this.conjunto instanceof ConjuntoMamushka);
    }
}
