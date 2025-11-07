package ar.edu.uade.progra2.grupo2.parte1.ejercicio15;

import tda.ConjuntoTDA;
import tda.GrafoTDA;

public class GradoVerticeGrafo {

    /**
     * 
     * <p><b>Estrategia:</b></p>
     * La estrategia utilizada es iterativa:
     * Calcula el grado de un vértice en un grafo dirigido, definido como la diferencia
     * entre la cantidad de aristas que salen del vértice y la cantidad de aristas que
     * llegan a él.
     *
     * <ul>
     *   <li>Se obtiene el conjunto de vértices del grafo.</li>
     *   <li>Se verifica si el vértice indicado pertenece al grafo. Si no pertenece, se devuelve 0.</li>
     *   <li>Se recorre el conjunto de vértices y, para cada vértice:</li>
     *   <li>Se verifica si existe una arista que salga del vértice objetivo hacia el actual,
     *         incrementando un contador de salidas en caso afirmativo.</li>
     *   <li>Se verifica si existe una arista que llegue desde el vértice actual al vértice objetivo,
     *         incrementando un contador de entradas en caso afirmativo.</li>
     *   <li>Se eliminan los vértices ya procesados del conjunto auxiliar, sin modificar la estructura del grafo original.</li>
     * </ul>
     *
     * <p>La estructura original del grafo no se modifica en ningún momento; solo se
     * trabaja sobre conjuntos auxiliares obtenidos a partir de él.</p>
     * 
     * @param grafo   grafo sobre el cual se calcula el grado
     * @param vertice vértice cuyo grado se desea calcular
     * @return la diferencia entre aristas salientes y entrantes del vértice
     */
    public static int calcular(GrafoTDA grafo, int vertice) {
        ConjuntoTDA vertices = grafo.vertices(); // C

        if (!vertices.pertenece(vertice)) return 0; // C

        int aristasQueSalen = 0; // C
        int aristasQueLleagan = 0; // C
        while (!vertices.conjuntoVacio()) { // L
            int v = vertices.elegir(); // C

            if (grafo.existeArista(vertice, v)) { // C
                aristasQueSalen++; // C
            }
            if (grafo.existeArista(v, vertice)) { // C
                aristasQueLleagan++; // C
            }
        
            vertices.sacar(v); // L
        }

        return aristasQueSalen - aristasQueLleagan; // C
    } // P

}
