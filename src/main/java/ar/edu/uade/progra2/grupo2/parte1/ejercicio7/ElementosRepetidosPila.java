package ar.edu.uade.progra2.grupo2.parte1.ejercicio7;

import imple.Pila;
import imple.Conjunto;
import tda.PilaTDA;
import tda.ConjuntoTDA;

/*Estrategia: Se utiliza una pila auxiliar para recorrer la pila original sin modificarla.
Dos conjuntos ayudan a identificar los repetidos:
vistos: guarda los elementos ya encontrados.
repetidos: guarda los que aparecen más de una vez.
Se pasan los datos a la pila auxiliar, luego se restauran en la pila original mientras se actualizan los conjuntos.
Finalmente, se devuelve el conjunto con los elementos repetidos.*/

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
