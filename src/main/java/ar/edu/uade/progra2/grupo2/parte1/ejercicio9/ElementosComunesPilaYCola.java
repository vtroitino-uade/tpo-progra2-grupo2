package ar.edu.uade.progra2.grupo2.parte1.ejercicio9;

import tda.PilaTDA;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import imple.Pila;
import imple.Cola;
import imple.Conjunto;

public class ElementosComunesPilaYCola {

    public static ConjuntoTDA obtener(PilaTDA pila, ColaTDA cola) {
        // No crear nada aún
        if (pila.pilaVacia() || cola.colaVacia()) {
            ConjuntoTDA conjuntoVacio = new Conjunto();
            conjuntoVacio.inicializarConjunto();
            return conjuntoVacio;
        }

        // Recién acá creamos estructuras
        ConjuntoTDA conjuntoResultado = new Conjunto();
        conjuntoResultado.inicializarConjunto();

        PilaTDA auxPila = new Pila();
        auxPila.inicializarPila();

        ColaTDA auxCola = new Cola();
        auxCola.inicializarCola();

        ConjuntoTDA elementosCola = new Conjunto();
        elementosCola.inicializarConjunto();

        // Copiar elementos de la cola a un conjunto
        while (!cola.colaVacia()) {
            int elem = cola.primero();
            cola.desacolar();
            elementosCola.agregar(elem);
            auxCola.acolar(elem);
        }

        // Restaurar la cola original
        while (!auxCola.colaVacia()) {
            int elem = auxCola.primero();
            auxCola.desacolar();
            cola.acolar(elem);
        }

        // Buscar coincidencias en la pila
        while (!pila.pilaVacia()) {
            int elem = pila.tope();
            pila.desapilar();

            if (elementosCola.pertenece(elem)) {
                conjuntoResultado.agregar(elem);
            }

            auxPila.apilar(elem);
        }

        // Restaurar la pila original
        while (!auxPila.pilaVacia()) {
            int elem = auxPila.tope();
            auxPila.desapilar();
            pila.apilar(elem);
        }

        return conjuntoResultado;
    }
}





