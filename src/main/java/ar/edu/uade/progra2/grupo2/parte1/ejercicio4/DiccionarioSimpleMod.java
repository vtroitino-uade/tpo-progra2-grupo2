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
        origen = null; // C
    } // C

    @Override
    public void agregar(int clave, int valor) {
        Nodo aux = origen; // C
        Nodo anterior = null; // C
        // Estrategia: se recorre la lista buscando la clave.
        // Si no existe, se agrega al principio.
        // Si existe, se actualiza y se incrementa el contador.
        //
        // Costo: Lineal — puede recorrer toda la lista.

        while (aux != null && aux.clave != clave) { // L
            anterior = aux; // C
            aux = aux.sig; // C
        }

        if (aux == null) { // C
            Nodo nuevo = new Nodo(); // C
            nuevo.clave = clave; // C
            nuevo.valor = valor; // C
            nuevo.modificaciones = 0; // C
            nuevo.sig = origen; // C
            origen = nuevo; // C
        } else {
            if (aux.valor != valor) { // C
                aux.valor = valor; // C
                aux.modificaciones++; // C
            }
        }
    } // L

    @Override
    public void eliminar(int clave) {
        Nodo aux = origen; // C
        Nodo anterior = null; // C

        // Estrategia: recorrer la lista hasta encontrar la claveas yy "saltearla" en los punteros.
        //
        // Costo: Lineal 
        while (aux != null && aux.clave != clave) { // L
            anterior = aux; // C
            aux = aux.sig; // C
        }

        if (aux != null) { // C
            if (anterior == null) { // C
                origen = aux.sig; // C
            } else {
                anterior.sig = aux.sig; // C
            }
        }
    } // L

    @Override
    public int recuperar(int clave) { //costo lineal
        Nodo aux = origen; // C
        while (aux != null && aux.clave != clave) { // L
            aux = aux.sig; // C
        }
        if (aux != null) { // C
            return aux.valor; // C
        } else {
            throw new IllegalArgumentException("Clave inexistente: " + clave); // C
        }
    } // L

    @Override
    public int recuperarMod(int clave) { //costo tambien lineal
        Nodo aux = origen; // C
        while (aux != null && aux.clave != clave) { // L
            aux = aux.sig; // C
        }
        if (aux != null) {
            return aux.modificaciones; // C
        } else {
            throw new IllegalArgumentException("Clave inexistente: " + clave); // C
        }
    } // L

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA c = new Conjunto(); // C
        c.inicializarConjunto(); // C
        Nodo aux = origen; // C
        while (aux != null) { // L
            c.agregar(aux.clave); // C
            aux = aux.sig; // C
        }
        return c; // C
    } // L
}
