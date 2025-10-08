package ar.edu.uade.progra2.grupo2.parte1.ejercicio5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imple.Conjunto;
import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;

public class DiccionarioSimplePrioridadTest {
    
    private DiccionarioSimpleTDA diccionario;

    @BeforeEach
    void setUp() {
        this.diccionario = new DiccionarioSimplePrioridad();
        this.diccionario.inicializarDiccionario();
    }

    @Test
    void testAgregarYRecuperar() {
        this.diccionario.agregar(1, 100);
        this.diccionario.agregar(2, 200);

        assertEquals(100, this.diccionario.recuperar(1));
        assertEquals(200, this.diccionario.recuperar(2));
    }

    @Test
    void testReemplazarValor() {
        this.diccionario.agregar(1, 100);
        this.diccionario.agregar(1, 300);
        assertEquals(300, this.diccionario.recuperar(1));
    }

    @Test
    void testEliminarClave() {
        this.diccionario.agregar(1, 10);
        this.diccionario.agregar(2, 20);
    
        this.diccionario.eliminar(1);

        assertFalse(this.diccionario.claves().pertenece(1));
        assertTrue(this.diccionario.claves().pertenece(2));
    }

        @Test
    void testRecuperarClaves() {
       this.diccionario.agregar(1, 10);
       this.diccionario.agregar(2, 20);
       this.diccionario.agregar(3, 30);

        ConjuntoTDA claves = this.diccionario.claves();
        ConjuntoTDA esperado = new Conjunto();
        esperado.inicializarConjunto();
        esperado.agregar(1);
        esperado.agregar(2);
        esperado.agregar(3);

        while (!claves.conjuntoVacio()) {
            int valor = claves.elegir();
            assertTrue(esperado.pertenece(valor));
            claves.sacar(valor);
        }
    }

    @Test
    void testActualizarValorNoDuplicaClaves() {
       this.diccionario.agregar(1, 10);
       this.diccionario.agregar(1, 20);
       this.diccionario.agregar(1, 30);

        ConjuntoTDA claves =this.diccionario.claves();
        int cantidad = 0;
        while (!claves.conjuntoVacio()) {
            claves.sacar(claves.elegir());
            cantidad++;
        }

        assertEquals(1, cantidad);
        assertEquals(30,this.diccionario.recuperar(1));
    }

    @Test
    void testDiccionarioVacio() {
        ConjuntoTDA claves =this.diccionario.claves();
        assertTrue(claves.conjuntoVacio());
    }

}
