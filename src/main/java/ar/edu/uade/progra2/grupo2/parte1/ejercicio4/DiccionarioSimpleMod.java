package ar.edu.uade.progra2.grupo2.parte1.ejercicio4;

import imple.Conjunto;
import tda.ConjuntoTDA;
/**
 * Estrategia:
 * Se utiliza una lista enlazada simple donde cada nodo contiene:
 * - clave
 * - valor
 * - contador de modificaciones (factorMod)
 *
 * Si se agrega una clave nueva → factorMod = 0
 * Si se vuelve a agregar la misma clave con un valor diferente → factorMod++
 * Si se agrega la misma clave con el mismo valor → no cambia nada
 */

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {

    private class Nodo {
        int clave;
        int valor;
        int modificaciones;
        Nodo sig;
    }

    private Nodo origen;

    @Override
    public void inicializarDiccionario() {
        origen = null;
    }

    @Override
    public void agregar(int clave, int valor) {
        Nodo aux = origen;
        Nodo anterior = null;
              // Estrategia: se recorre la lista buscando la clave.
        // Si no existe, se agrega al principio.
        // Si existe, se actualiza y se incrementa el contador.
        //
        // Costo: Lineal — puede recorrer toda la lista.

        while (aux != null && aux.clave != clave) {
            anterior = aux;
            aux = aux.sig;
        }

        if (aux == null) {
            Nodo nuevo = new Nodo();
            nuevo.clave = clave;
            nuevo.valor = valor;
            nuevo.modificaciones = 0;
            nuevo.sig = origen;
            origen = nuevo;
        } else {
            if (aux.valor != valor) {
                aux.valor = valor;
                aux.modificaciones++;
            }
        }
    }

    @Override
    public void eliminar(int clave) {
        Nodo aux = origen;
        Nodo anterior = null;

     // Estrategia: recorrer la lista hasta encontrar la claveas yy "saltearla" en los punteros.
        //
        // Costo: Lineal 
        while (aux != null && aux.clave != clave) {
            anterior = aux;
            aux = aux.sig;
        }

        if (aux != null) {
            if (anterior == null) {
                origen = aux.sig;
            } else {
                anterior.sig = aux.sig;
            }
        }
    }

    @Override
    public int recuperar(int clave) { //colsto lineal
        Nodo aux = origen;
        while (aux != null && aux.clave != clave) {
            aux = aux.sig;
        }
        if (aux != null) {
            return aux.valor;
        } else {
            throw new IllegalArgumentException("Clave inexistente: " + clave);
        }
    }

    @Override
    public int recuperarMod(int clave) { //costo tambien lineal
        Nodo aux = origen;
        while (aux != null && aux.clave != clave) {
            aux = aux.sig;
        }
        if (aux != null) {
            return aux.modificaciones;
        } else {
            throw new IllegalArgumentException("Clave inexistente: " + clave);
        }
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA c = new Conjunto();
        c.inicializarConjunto();
        Nodo aux = origen;
        while (aux != null) {
            c.agregar(aux.clave);
            aux = aux.sig;
        }
        return c;
    }
}
