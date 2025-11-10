package ar.edu.uade.progra2.grupo2.parte1.ejercicio8;

import tda.ColaTDA;
import tda.ConjuntoTDA;
import imple.Cola;
import imple.Conjunto;
/*
 * Estrategia utilizada: RECORRIDO ITERATIVO CON CONJUNTO Y COLA AUXILIAR.
 *
 * El objetivo es devolver una nueva cola sin elementos repetidos, conservando
 * el orden en que aparecen por primera vez en la cola original.
 *
 *Se recorre la cola original elemento por elemento.
 *Se usa un conjunto para recordar qué valores ya fueron agregados.
 *Si el elemento aún no está en el conjunto, se incorpora a la cola nueva.
 *En todos los casos, el elemento se guarda temporalmente en una cola auxiliar,
 *para luego restaurar la cola original.
 *
 *Finalmente se restaura el contenido de la cola original y se devuelve la cola nueva.
 */
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
