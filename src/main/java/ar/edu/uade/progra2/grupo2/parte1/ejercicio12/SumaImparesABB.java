package ar.edu.uade.progra2.grupo2.parte1.ejercicio12;

import tda.ABBTDA;

public class SumaImparesABB {

    public static int calcular(ABBTDA abb) {
        if (abb.arbolVacio()) {
            return 0;
        }

        int suma = 0;

        int valorRaiz = abb.raiz();
        if (valorRaiz % 2 != 0) {
            suma += valorRaiz;
        }

        suma += calcular(abb.hijoIzq());
        suma += calcular(abb.hijoDer());

        return suma;
    }
}
