package ar.edu.uade.progra2.grupo2.parte1.ejercicio8;

import tda.ColaTDA;
import tda.ConjuntoTDA;
import imple.Cola;
import imple.Conjunto;

public class ColaSinRepetidos {
    
	public static ColaTDA obtener(ColaTDA colaOriginal) {
        ColaTDA colaNueva = new Cola(); // C
        colaNueva.inicializarCola(); // C

        ColaTDA aux = new Cola(); // C
        aux.inicializarCola(); // C

        ConjuntoTDA valoresAgregados = new Conjunto(); // C
        valoresAgregados.inicializarConjunto(); // C

        // Recorremos la cola original
        while (!colaOriginal.colaVacia()) { // L
            int elem = colaOriginal.primero(); // C
            colaOriginal.desacolar(); // C

            if (!valoresAgregados.pertenece(elem)) { // L
                valoresAgregados.agregar(elem); // L
                colaNueva.acolar(elem); // L
            }

            aux.acolar(elem); // L
        }

        // Restauramos la cola original
        while (!aux.colaVacia()) {  // L
            int elem = aux.primero(); // C
            aux.desacolar(); // C
            colaOriginal.acolar(elem); // L
        }

        return colaNueva; // C
    } // P
}
