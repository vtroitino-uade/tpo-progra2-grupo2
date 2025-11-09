package ar.edu.uade.progra2.grupo2.parte1.ejercicio11;

import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;
import imple.Cola;
import imple.Conjunto;

/**
 * Estrategia utilizada: RECORRIDO ITERATIVO CON CONJUNTO AUXILIAR.
 *
 * Se recorren todas las claves del Diccionario Múltiple de forma iterativa.
 * Para cada clave, se obtienen sus valores asociados.
 * Se usa un conjunto auxiliar para asegurarse de que cada valor se encole una sola vez,
 * evitando duplicados. Finalmente, se devuelve una cola con todos los valores únicos
 * presentes en el diccionario.
 */

public class ValoresUnicosDiccionario {

    public static ColaTDA obtener(DiccionarioMultipleTDA dic) {
        ColaTDA cola = new Cola(); // Cola donde se guardarán los valores únicos
        cola.inicializarCola(); // Inicializa la cola

        ConjuntoTDA claves = dic.claves(); // Obtiene todas las claves del diccionario
        ConjuntoTDA valoresAgregados = new Conjunto(); // Conjunto auxiliar para evitar duplicados
        valoresAgregados.inicializarConjunto(); // Inicializa el conjunto

        // Recorre todas las claves del diccionario
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir(); // Toma una clave cualquiera
            claves.sacar(clave); // La elimina del conjunto de claves para no repetir

            ConjuntoTDA valores = dic.recuperar(clave); // Obtiene los valores asociados a esa clave

            // Recorre todos los valores asociados a la clave
            while (!valores.conjuntoVacio()) {
                int valor = valores.elegir(); // Toma un valor cualquiera del conjunto
                valores.sacar(valor); // Lo elimina del conjunto de valores

                // Si el valor no fue agregado antes, lo encola y lo guarda como agregado
                if (!valoresAgregados.pertenece(valor)) {
                    cola.acolar(valor); // Encola el valor único
                    valoresAgregados.agregar(valor); // Marca que ya fue agregado
                }
            }
        }

        return cola; // Devuelve la cola con todos los valores únicos del diccionario
    }
}
