package ar.edu.uade.progra2.grupo2.parte1.ejercicio8;

import tda.ColaTDA;
import tda.ConjuntoTDA;
import imple.Cola;
import imple.Conjunto;

public class ColaSinRepetidos {
    
	public static ColaTDA obtener(ColaTDA colaOriginal) {
        ColaTDA colaNueva = new Cola();
        colaNueva.inicializarCola();

        ColaTDA aux = new Cola();
        aux.inicializarCola();

        ConjuntoTDA valoresAgregados = new Conjunto();
        valoresAgregados.inicializarConjunto();

        // Recorremos la cola original
        while (!colaOriginal.colaVacia()) {
            int elem = colaOriginal.primero();
            colaOriginal.desacolar();

            if (!valoresAgregados.pertenece(elem)) {
                valoresAgregados.agregar(elem);
                colaNueva.acolar(elem);
            }

            aux.acolar(elem);
        }

        // Restauramos la cola original
        while (!aux.colaVacia()) {
            int elem = aux.primero();
            aux.desacolar();
            colaOriginal.acolar(elem);
        }

        return colaNueva;
    }
}
