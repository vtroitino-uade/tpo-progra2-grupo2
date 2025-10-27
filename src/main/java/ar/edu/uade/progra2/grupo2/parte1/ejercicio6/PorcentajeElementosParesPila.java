package ar.edu.uade.progra2.grupo2.parte1.ejercicio6;

import imple.Pila;
import tda.PilaTDA;

public class PorcentajeElementosParesPila {

    public static float calcular(PilaTDA pila) {
        // pila auxiliar para no modificar la original
        PilaTDA aux = new Pila();
        aux.inicializarPila();

        int total = 0;
        int pares = 0;

        // recorro la pila original
        while (!pila.pilaVacia()) {
            int valor = pila.tope();
            pila.desapilar();
            total++;

            if (valor % 2 == 0) {
                pares++;
            }

            aux.apilar(valor);
        }

        // restauro la pila original
        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        // si la pila está vacía devuelvo 0
        if (total == 0) {
            return 0.0f;
        }

        // devuelvo el porcentaje
        return (pares * 100f) / total;
    }
}
