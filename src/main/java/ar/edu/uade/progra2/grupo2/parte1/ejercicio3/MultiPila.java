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
        tope = null;
    }

    @Override
    public boolean pilaVacia() {
        return tope == null;
    }

    @Override
    public void apilar(PilaTDA valores) {
        if (valores.pilaVacia()) return;

        PilaTDA aux = new Pila();
        aux.inicializarPila();

        while (!valores.pilaVacia()) {
            aux.apilar(valores.tope());
            valores.desapilar();
        }

        while (!aux.pilaVacia()) {
            int val = aux.tope();
            this.apilarValor(val);
            valores.apilar(val);
            aux.desapilar();
        }
    }

    private void apilarValor(int valor) {
        Nodo nuevo = new Nodo();
        nuevo.valor = valor;
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    
@Override
public void desapilar(PilaTDA valores) {
    if (pilaVacia() || valores.pilaVacia()) return;

    PilaTDA copia = new Pila();
    copia.inicializarPila();
    PilaTDA aux = new Pila();
    aux.inicializarPila();

    
    PilaTDA temp = new Pila();
    temp.inicializarPila();
    while (!valores.pilaVacia()) {
        temp.apilar(valores.tope());
        valores.desapilar();
    }
    while (!temp.pilaVacia()) {
        int v = temp.tope();
        valores.apilar(v);   
        aux.apilar(v);       
        temp.desapilar();
    }

    
    while (!aux.pilaVacia()) {
        copia.apilar(aux.tope());
        aux.desapilar();
    }

    
    Nodo cursor = tope;
    boolean coincide = true;

    PilaTDA auxComp = new Pila();
    auxComp.inicializarPila();

    while (!copia.pilaVacia()) {
        if (cursor == null || cursor.valor != copia.tope()) {
            coincide = false;
            break;
        }
        auxComp.apilar(copia.tope());
        copia.desapilar();
        cursor = cursor.siguiente;
    }

    if (!coincide) return;

    
    while (!auxComp.pilaVacia()) {
        desapilarValor();
        auxComp.desapilar();
    }
}



    private void desapilarValor() {
        if (tope != null) {
            tope = tope.siguiente;
        }
    }

    @Override
    public PilaTDA tope(int cantidad) {
        PilaTDA resultado = new Pila();
        resultado.inicializarPila();

        PilaTDA aux = new Pila();
        aux.inicializarPila();

        Nodo actual = tope;
        int count = 0;

        while (actual != null && count < cantidad) {
            aux.apilar(actual.valor);
            actual = actual.siguiente;
            count++;
        }

        while (!aux.pilaVacia()) {
            resultado.apilar(aux.tope());
            aux.desapilar();
        }

        return resultado;
    }
}

