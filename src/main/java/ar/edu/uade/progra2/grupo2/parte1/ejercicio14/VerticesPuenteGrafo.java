package ar.edu.uade.progra2.grupo2.parte1.ejercicio14;

import imple.Conjunto;
import tda.ConjuntoTDA;
import tda.GrafoTDA;

public class VerticesPuenteGrafo {

    public static ConjuntoTDA obtener(GrafoTDA grafo, int origen, int destino) {        
        ConjuntoTDA puentes = new Conjunto();
        puentes.inicializarConjunto();

        ConjuntoTDA vertices = grafo.vertices();
        if (!vertices.pertenece(origen) || !vertices.pertenece(destino)) {
            return puentes;
        }

        vertices.sacar(origen);
        vertices.sacar(destino);

        while (!vertices.conjuntoVacio()) {
            int puente = vertices.elegir();
            if (grafo.existeArista(origen, puente) && grafo.existeArista(puente, destino)) {
                puentes.agregar(puente);
            }
            vertices.sacar(puente);
        }

        return puentes;
    }

}
