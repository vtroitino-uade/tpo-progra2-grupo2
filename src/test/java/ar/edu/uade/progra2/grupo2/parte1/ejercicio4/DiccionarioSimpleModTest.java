package ar.edu.uade.progra2.grupo2.parte1.ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiccionarioSimpleModTest {

    private DiccionarioSimpleModTDA diccionario;

    @BeforeEach
    void setUp() {
        this.diccionario = new DiccionarioSimpleMod();
        this.diccionario.inicializarDiccionario();
    }

    @Test
    void testAgregarValores() {
        int primerClave = 1;
        int segundaClave = 5;
        int terceraClave = 7;
        int primerValor = 10;
        int segundoValor = 4;
        int tercerValor = 2;
        int cantidadModificaicones = 0;
        this.diccionario.agregar(primerClave, primerValor);
        this.diccionario.agregar(segundaClave, segundoValor);
        this.diccionario.agregar(terceraClave, tercerValor);

        assertEquals(primerValor, this.diccionario.recuperar(primerClave));
        assertEquals(segundoValor, this.diccionario.recuperar(segundaClave));
        assertEquals(tercerValor, this.diccionario.recuperar(terceraClave));
        assertEquals(cantidadModificaicones, this.diccionario.recuperarMod(primerClave));
        assertEquals(cantidadModificaicones, this.diccionario.recuperarMod(segundaClave));
        assertEquals(cantidadModificaicones, this.diccionario.recuperarMod(terceraClave));
    }

    @Test
    void testModificarValor() {
        int clave = 1;
        int primerValor = 9;
        int segundoValor = 7;
        int valorEsperado = 10;
        int cantidadModificaicones = 2;
        this.diccionario.agregar(clave, primerValor);
        this.diccionario.agregar(clave, segundoValor);
        this.diccionario.agregar(clave, valorEsperado);

        assertEquals(valorEsperado, this.diccionario.recuperar(clave));
        assertEquals(cantidadModificaicones, this.diccionario.recuperarMod(clave));
    }

    @Test
    void testEliminarValor() {
        int primerClave = 1;
        int segundaClave = 2;
        int primerValor = 9;
        int segundoValor = 7;
        int cantidadModificaicones = 0;
        this.diccionario.agregar(primerClave, primerValor);
        this.diccionario.agregar(segundaClave, segundoValor);

        this.diccionario.eliminar(segundaClave);
    
        assertEquals(primerValor, this.diccionario.recuperar(primerClave));
        assertEquals(cantidadModificaicones, this.diccionario.recuperarMod(primerClave));
        assertTrue(this.diccionario.claves().pertenece(primerClave));
        assertFalse(this.diccionario.claves().pertenece(segundaClave));
    }

}
