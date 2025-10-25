package ar.edu.uade.progra2.grupo2.parte1.ejercicio7;

import imple.Pila;
import imple.Conjunto;
import tda.PilaTDA;
import tda.ConjuntoTDA;

public class ElementosRepetidosPila {

    public static ConjuntoTDA obtener(PilaTDA pila) {
        PilaTDA aux = new Pila();
        ConjuntoTDA repetidos = new Conjunto();
        ConjuntoTDA vistos = new Conjunto();

        aux.inicializarPila();
        repetidos.inicializarConjunto();
        vistos.inicializarConjunto();

        // Paso los datos a una pila auxiliar para poder recorrerlos
        while(!pila.pilaVacia()) {
            int valor = pila.tope();
            pila.desapilar();
            aux.apilar(valor);
        }

        // Recorro los elementos y restauro la pila original
        while(!aux.pilaVacia()) {
            int actual = aux.tope();
            aux.desapilar();
            pila.apilar(actual);

            if(vistos.pertenece(actual)) {
                repetidos.agregar(actual);
            } else {
                vistos.agregar(actual);
            }
        }

        return repetidos;
    }
}
