package ar.edu.uade.progra2.grupo2.parte1.ejercicio13;

import tda.ABBTDA;

public class CantidadHojasParesABB {

    /**
     * Estrategia:
     * La estrategia utilizada en este método es recursiva y cuenta con dos casos base:
     * 
     * - El primero verifica si el árbol está vacío; en ese caso, devuelve 0.
     * - El segundo determina si el nodo actual es una hoja, comprobando que
     *   tanto el subárbol izquierdo como el derecho estén vacíos. Si la raíz
     *   del nodo es un número par, devuelve 1; de lo contrario, devuelve 0.
     * 
     * Por último, en el caso recursivo, se retorna la suma de las llamadas al método
     * sobre el subárbol izquierdo y el subárbol derecho, garantizando así que se
     * recorran y evalúen todos los nodos del árbol.
     * 
     * @param arbol arbol en el que se buscan las hojas
     * @return la cantidad de hojas pares
     */
    public static int calcular(ABBTDA arbol) {
        if (arbol.arbolVacio()) return 0;

        if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio())
            return (arbol.raiz() % 2 == 0) ? 1 : 0;

        return calcular(arbol.hijoIzq()) + calcular(arbol.hijoDer());
    }

}
