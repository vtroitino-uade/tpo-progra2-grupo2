package ar.edu.uade.progra2.grupo2.parte1.ejercicio7;

import imple.Pila;
import imple.Conjunto;
import tda.PilaTDA;
import tda.ConjuntoTDA;

public class ElementosRepetidosPila {

    public static ConjuntoTDA obtener(PilaTDA pila) {
        PilaTDA aux = new Pila(); // C
        ConjuntoTDA repetidos = new Conjunto(); // C
        ConjuntoTDA vistos = new Conjunto(); // C

        aux.inicializarPila(); // C
        repetidos.inicializarConjunto(); // C
        vistos.inicializarConjunto(); // C

        // Paso los datos a una pila auxiliar para poder recorrerlos
        while(!pila.pilaVacia()) { // L
            int valor = pila.tope(); // C
            pila.desapilar(); // C
            aux.apilar(valor); // C
        }

        // Recorro los elementos y restauro la pila original
        while(!aux.pilaVacia()) { // L
            int actual = aux.tope(); // C
            aux.desapilar(); // C
            pila.apilar(actual); // C

            if(vistos.pertenece(actual)) { // L
                repetidos.agregar(actual); // L
            } else { 
                vistos.agregar(actual); // L
            }
        }

        return repetidos; // C
    } // P
}
