package ar.edu.uade.progra2.grupo2.parte1.ejercicio10;

import tda.DiccionarioSimpleTDA;
import tda.PilaTDA;
import tda.ConjuntoTDA;
import imple.DiccionarioSimple;
import imple.Pila;

/**
 * Estrategia utilizada: RECORRIDO ITERATIVO CON ESTRUCTURA AUXILIAR.
 *
 * Se recorre la pila original de forma iterativa y se utiliza una pila auxiliar
 * para no perder los elementos durante el proceso.
 * Por cada elemento, se actualiza un diccionario simple que lleva la cuenta de cuántas
 * veces aparece (frecuencia).
 * Finalmente, se restaura la pila original y se devuelve el diccionario con los resultados.
 */
public class FrecuenciaElementosPila {

    public static DiccionarioSimpleTDA obtener(PilaTDA pila) {
        PilaTDA aux = new Pila(); // Pila auxiliar para no perder los elementos
        aux.inicializarPila(); // Inicializa la pila auxiliar

        DiccionarioSimpleTDA dic = new DiccionarioSimple(); // Diccionario para guardar elemento -> frecuencia
        dic.inicializarDiccionario(); // Inicializa el diccionario

        // Recorre la pila original para contar las frecuencias
        while (!pila.pilaVacia()) {
            int elem = pila.tope(); // Obtiene el elemento del tope
            pila.desapilar(); // Lo saca de la pila

            ConjuntoTDA claves = dic.claves(); // Obtiene las claves actuales del diccionario
            boolean existe = claves.pertenece(elem); // Verifica si el elemento ya fue contado

            if (existe) {
                int valor = dic.recuperar(elem); // Recupera la frecuencia actual
                dic.eliminar(elem); // Elimina la entrada vieja
                dic.agregar(elem, valor + 1); // Agrega la nueva frecuencia actualizada
            } else {
                dic.agregar(elem, 1); // Si no existía, lo agrega con frecuencia 1
            }

            aux.apilar(elem); // Guarda el elemento en la pila auxiliar
        }

        // Restaura la pila original (para no perder su contenido)
        while (!aux.pilaVacia()) {
            int elem = aux.tope(); // Obtiene el elemento del tope de la auxiliar
            aux.desapilar(); // Lo saca de la auxiliar
            pila.apilar(elem); // Lo vuelve a apilar en la pila original
        }

        return dic; // Devuelve el diccionario con las frecuencias
    }
}
