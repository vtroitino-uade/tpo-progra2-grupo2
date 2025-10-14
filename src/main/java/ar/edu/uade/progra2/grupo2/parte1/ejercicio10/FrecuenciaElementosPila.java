package ar.edu.uade.progra2.grupo2.parte1.ejercicio10;

import tda.DiccionarioSimpleTDA;
import tda.PilaTDA;
import tda.ConjuntoTDA;
import imple.DiccionarioSimple;
import imple.Pila;

public class FrecuenciaElementosPila {

    public static DiccionarioSimpleTDA obtener(PilaTDA pila) {
        PilaTDA aux = new Pila();
        aux.inicializarPila();

        DiccionarioSimpleTDA dic = new DiccionarioSimple();
        dic.inicializarDiccionario();

        while (!pila.pilaVacia()) {
            int elem = pila.tope();
            pila.desapilar();

            ConjuntoTDA claves = dic.claves();
            boolean existe = claves.pertenece(elem);

            if (existe) {
                int valor = dic.recuperar(elem);
                dic.eliminar(elem);
                dic.agregar(elem, valor + 1);
            } else {
                dic.agregar(elem, 1);
            }

            aux.apilar(elem);
        }

        while (!aux.pilaVacia()) {
            int elem = aux.tope();
            aux.desapilar();
            pila.apilar(elem);
        }

        return dic;
    }
}
