package ar.edu.uade.progra2.grupo2.parte1.ejercicio7;

import imple.PilaLD;
import imple.ConjuntoLD;
import tda.PilaTDA;
import tda.ConjuntoTDA;

public class ElementosRepetidosPila {

    public ConjuntoTDA elementosRepetidos(PilaTDA pila) {
        PilaTDA aux1 = new PilaLD();
        PilaTDA aux2 = new PilaLD();
        ConjuntoTDA repetidos = new ConjuntoLD();
        ConjuntoTDA vistos = new ConjuntoLD();

        aux1.inicializarPila();
        aux2.inicializarPila();
        repetidos.inicializarConjunto();
        vistos.inicializarConjunto();

        // Paso los datos a una pila auxiliar para poder recorrerlos
        while(!pila.pilaVacia()) {
            int valor = pila.tope();
            pila.desapilar();
            aux1.apilar(valor);
        }

        // Recorro los elementos
        while(!aux1.pilaVacia()) {
            int actual = aux1.tope();
            aux1.desapilar();
            aux2.apilar(actual);

            if(vistos.pertenece(actual)) {
                repetidos.agregar(actual);
            } else {
                vistos.agregar(actual);
            }
        }

        // Restaura la pila original
        while(!aux2.pilaVacia()) {
            pila.apilar(aux2.tope());
            aux2.desapilar();
        }

        return repetidos;
    }
}
