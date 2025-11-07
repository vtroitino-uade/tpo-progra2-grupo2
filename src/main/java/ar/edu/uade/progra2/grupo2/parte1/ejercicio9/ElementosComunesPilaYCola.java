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
        if (pila.pilaVacia() || cola.colaVacia()) { // C 
            ConjuntoTDA conjuntoVacio = new Conjunto(); // C
            conjuntoVacio.inicializarConjunto(); // C
            return conjuntoVacio; // C
        }

        // Recién acá creamos estructuras
        ConjuntoTDA conjuntoResultado = new Conjunto(); // C
        conjuntoResultado.inicializarConjunto(); // C

        PilaTDA auxPila = new Pila(); // C
        auxPila.inicializarPila(); // C

        ColaTDA auxCola = new Cola(); // C
        auxCola.inicializarCola(); // C

        ConjuntoTDA elementosCola = new Conjunto(); // C
        elementosCola.inicializarConjunto(); // C

        // Copiar elementos de la cola a un conjunto
        while (!cola.colaVacia()) { // L
            int elem = cola.primero(); // C
            cola.desacolar(); // C
            elementosCola.agregar(elem); // L
            auxCola.acolar(elem); // L
        }

        // Restaurar la cola original
        while (!auxCola.colaVacia()) { // L
            int elem = auxCola.primero(); // C
            auxCola.desacolar(); // C
            cola.acolar(elem); // L
        }

        // Buscar coincidencias en la pila
        while (!pila.pilaVacia()) { // L
            int elem = pila.tope(); // C
            pila.desapilar(); // C

            if (elementosCola.pertenece(elem)) { // L
                conjuntoResultado.agregar(elem); // L
            }

            auxPila.apilar(elem); // C
        }

        // Restaurar la pila original
        while (!auxPila.pilaVacia()) { // L
            int elem = auxPila.tope(); // C
            auxPila.desapilar(); // C
            pila.apilar(elem); // C
        }

        return conjuntoResultado; // C
    } // P
}





