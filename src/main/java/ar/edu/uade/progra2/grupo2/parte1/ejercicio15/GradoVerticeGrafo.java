package ar.edu.uade.progra2.grupo2.parte1.ejercicio15;

import tda.ConjuntoTDA;
import tda.GrafoTDA;

public class GradoVerticeGrafo {

    public static int calcular(GrafoTDA grafo, int vertice) {
        ConjuntoTDA vertices = grafo.vertices();

        if (!vertices.pertenece(vertice)) return 0;

        int aristasQueSalen = 0;
        int aristasQueLleagan = 0;
        while (!vertices.conjuntoVacio()) {
            int v = vertices.elegir();

            if (grafo.existeArista(vertice, v)) {
                aristasQueSalen++;
            }
            if (grafo.existeArista(v, vertice)) {
                aristasQueLleagan++;
            }
        
            vertices.sacar(v);
        }

        return aristasQueSalen - aristasQueLleagan;
    }

}
