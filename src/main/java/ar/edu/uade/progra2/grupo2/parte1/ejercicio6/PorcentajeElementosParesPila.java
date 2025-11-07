package ar.edu.uade.progra2.grupo2.parte1.ejercicio6;

import imple.Pila;
import tda.PilaTDA;

public class PorcentajeElementosParesPila {

    public static float calcular(PilaTDA pila) {
        // pila auxiliar para no modificar la original
        PilaTDA aux = new Pila(); // C
        aux.inicializarPila(); // C

        int total = 0; // C
        int pares = 0; // C

        // recorro la pila original
        while (!pila.pilaVacia()) { // L
            int valor = pila.tope(); // C
            pila.desapilar(); // C
            total++; // C

            if (valor % 2 == 0) { // C
                pares++; // C
            }

            aux.apilar(valor); // C
        }

        // restauro la pila original
        while (!aux.pilaVacia()) { // L
            pila.apilar(aux.tope()); // C
            aux.desapilar(); // C
        }

        // si la pila está vacía devuelvo 0
        if (total == 0) { // C
            return 0.0f; // C
        }

        // devuelvo el porcentaje
        return (pares * 100f) / total; // C
    } // L
}
