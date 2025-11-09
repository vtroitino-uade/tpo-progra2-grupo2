package ar.edu.uade.progra2.grupo2.parte1.ejercicio14;

import imple.Conjunto;
import tda.ConjuntoTDA;
import tda.GrafoTDA;

public class VerticesPuenteGrafo {

    /**
     * 
     * Estrategia:
     * La estrategia utilizada es iterativa y selectiva:
     * Obtiene el conjunto de vértices que funcionan como "puentes" entre un vértice
     * de origen y uno de destino, es decir, aquellos vértices que poseen una arista
     * entrante desde el origen y una arista saliente hacia el destino.
     *
     *- Se inicializa un conjunto auxiliar vacío para almacenar los vértices puente.
     *- Se obtiene el conjunto de vértices del grafo y se verifica que tanto el origen
     *  como el destino pertenezcan a él.
     *- Se eliminan origen y destino del conjunto auxiliar para no considerarlos
     *  como posibles puentes.
     *- Se recorre cada vértice restante y se verifica si existe una arista
     *  desde el origen hacia ese vértice y otra desde el vértice hacia el destino.
     *- Si ambas condiciones se cumplen, el vértice se agrega al conjunto de puentes.
     *
     * La estructura original del grafo no se modifica en ningún momento; solo se
     * trabaja sobre conjuntos auxiliares obtenidos a partir de él.
     *
     *
     * @param grafo   grafo sobre el cual se buscan los vértices puente
     * @param origen  vértice de origen
     * @param destino vértice de destino
     * @return conjunto de vértices puente entre origen y destino
     */
    public static ConjuntoTDA obtener(GrafoTDA grafo, int origen, int destino) {
        ConjuntoTDA puentes = new Conjunto(); // C
        puentes.inicializarConjunto(); // C

        ConjuntoTDA vertices = grafo.vertices(); // C
        if (!vertices.pertenece(origen) || !vertices.pertenece(destino)) { // C
            return puentes; // C
        }

        vertices.sacar(origen); // L
        vertices.sacar(destino); // L

        while (!vertices.conjuntoVacio()) { // L
            int puente = vertices.elegir(); // C
            if (grafo.existeArista(origen, puente) && grafo.existeArista(puente, destino)) { // C
                puentes.agregar(puente); // C
            }
            vertices.sacar(puente); // L
        } // P

        return puentes; // C
    } // P

}
