package ar.edu.uade.progra2.grupo2.parte1.ejercicio10;

import tda.DiccionarioSimpleTDA;
import tda.PilaTDA;
import tda.ConjuntoTDA;
import imple.DiccionarioSimple;
import imple.Pila;

public class FrecuenciaElementosPila {

    public static DiccionarioSimpleTDA obtener(PilaTDA pila) {
        PilaTDA aux = new Pila(); // C
        aux.inicializarPila(); // C

        DiccionarioSimpleTDA dic = new DiccionarioSimple(); // C
        dic.inicializarDiccionario(); // C

        while (!pila.pilaVacia()) { // L
            int elem = pila.tope(); // C
            pila.desapilar(); // C

            ConjuntoTDA claves = dic.claves(); // L
            boolean existe = claves.pertenece(elem); // L

            if (existe) { // C
                int valor = dic.recuperar(elem); // L
                dic.eliminar(elem); // L
                dic.agregar(elem, valor + 1); // L
            } else {
                dic.agregar(elem, 1); // L
            }

            aux.apilar(elem); // C
        }

        while (!aux.pilaVacia()) { // L
            int elem = aux.tope(); // C
            aux.desapilar(); // C
            pila.apilar(elem); // C
        }

        return dic; // C
    } // P
}
