package ar.edu.uade.progra2.grupo2.parte1.ejercicio12;

import tda.ABBTDA;

/**
 * Estrategia utilizada: RECURSIÓN.
 *
 * Se recorre el árbol binario de búsqueda (ABB) de forma recursiva.
 * En cada nodo se evalúa si su valor es impar y, si lo es, se suma al total.
 * Luego se aplican llamadas recursivas a los subárboles izquierdo y derecho
 * para acumular la suma de todos los valores impares del árbol.
 */

public class SumaImparesABB {

    public static int calcular(ABBTDA abb) {
        // Caso base: si el árbol está vacío, la suma es 0
        if (abb.arbolVacio()) {
            return 0;
        }

        int suma = 0;

        int valorRaiz = abb.raiz(); // Obtiene el valor de la raíz actual

        // Si el valor de la raíz es impar, lo suma
        if (valorRaiz % 2 != 0) {
            suma += valorRaiz;
        }

        // Llamada recursiva al hijo izquierdo y derecho
        // Se acumula la suma de los valores impares de ambos subárboles
        suma += calcular(abb.hijoIzq());
        suma += calcular(abb.hijoDer());

        // Devuelve la suma total de los impares del subárbol actual
        return suma;
    }
}
