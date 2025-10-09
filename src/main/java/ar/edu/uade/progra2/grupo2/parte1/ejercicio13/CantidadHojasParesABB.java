package ar.edu.uade.progra2.grupo2.parte1.ejercicio13;

import tda.ABBTDA;

public class CantidadHojasParesABB {

    public static int calcular(ABBTDA arbol) {
        if (arbol.arbolVacio()) return 0;

        if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio())
            return (arbol.raiz() % 2 == 0) ? 1 : 0;

        return calcular(arbol.hijoIzq()) + calcular(arbol.hijoDer());
    }

}
