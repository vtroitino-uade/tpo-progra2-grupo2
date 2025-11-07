package ar.edu.uade.progra2.grupo2.parte1.ejercicio3;

import imple.Pila;
import tda.PilaTDA;

public class MultiPila implements MultipilaTDA {

    private Nodo tope;

    private class Nodo {
        int valor;
        Nodo siguiente;
    }

    @Override
    public void inicializarPila() {
        tope = null; // C
    } // C

    @Override
    public boolean pilaVacia() {
        return tope == null; // C
    } // C

    @Override
    public void apilar(PilaTDA valores) {
        if (valores.pilaVacia()) return; // C

        PilaTDA aux = new Pila(); // C
        aux.inicializarPila(); // C

        while (!valores.pilaVacia()) { // L
            aux.apilar(valores.tope()); // C
            valores.desapilar(); // C
        }

        while (!aux.pilaVacia()) {  // L
            int val = aux.tope(); // C
            this.apilarValor(val); // C
            valores.apilar(val); // C
            aux.desapilar(); // C
        }
    } // L

    private void apilarValor(int valor) {
        Nodo nuevo = new Nodo(); // C
        nuevo.valor = valor; // C
        nuevo.siguiente = tope; // C
        tope = nuevo; // C
    }

    
    @Override
    public void desapilar(PilaTDA valores) {
        if (pilaVacia() || valores.pilaVacia()) return; // C
    
        PilaTDA copia = new Pila(); // C
        copia.inicializarPila(); // C
        PilaTDA aux = new Pila(); // C
        aux.inicializarPila(); // C

        
        PilaTDA temp = new Pila(); // C
        temp.inicializarPila(); // C
        while (!valores.pilaVacia()) { // L
            temp.apilar(valores.tope()); // C
            valores.desapilar(); // C
        }
        while (!temp.pilaVacia()) { // L
            int v = temp.tope(); // C
            valores.apilar(v); // C
            aux.apilar(v); // C
            temp.desapilar(); // C
        }

        
        while (!aux.pilaVacia()) { // L
            copia.apilar(aux.tope()); // C
            aux.desapilar(); // C
        }

        
        Nodo cursor = tope; // C 
        boolean coincide = true; // C

        PilaTDA auxComp = new Pila(); // C
        auxComp.inicializarPila(); // C

        while (!copia.pilaVacia()) { // L
            if (cursor == null || cursor.valor != copia.tope()) { // C
                coincide = false; // C
            } else {
                auxComp.apilar(copia.tope()); // C
                copia.desapilar(); // C
                cursor = cursor.siguiente; // C
            }
        }

        if (!coincide) return; // C

        
        while (!auxComp.pilaVacia()) { // L
            desapilarValor(); // C
            auxComp.desapilar(); // C
        }
    } // L

    private void desapilarValor() {
        if (tope != null) { // C
            tope = tope.siguiente; // C
        }
    } // C

    @Override
    public PilaTDA tope(int cantidad) {
        PilaTDA resultado = new Pila(); // C
        resultado.inicializarPila(); // C

        PilaTDA aux = new Pila(); // C
        aux.inicializarPila(); // C

        Nodo actual = tope; // C
        int count = 0; // C

        while (actual != null && count < cantidad) { // L
            aux.apilar(actual.valor); // C
            actual = actual.siguiente; // C
            count++; // C
        }

        while (!aux.pilaVacia()) { // L
            resultado.apilar(aux.tope()); // C
            aux.desapilar(); // C
        }

        return resultado; // C
    } // L
}

