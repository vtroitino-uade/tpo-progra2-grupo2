package ar.edu.uade.progra2.grupo2.parte1.ejercicio11;

import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;
import imple.Cola;
import imple.Conjunto;

public class ValoresUnicosDiccionario {

    public static ColaTDA obtener(DiccionarioMultipleTDA dic) {
        ColaTDA cola = new Cola(); // C
        cola.inicializarCola(); // C

        ConjuntoTDA claves = dic.claves(); // L
        ConjuntoTDA valoresAgregados = new Conjunto(); // C
        valoresAgregados.inicializarConjunto(); // C

        while (!claves.conjuntoVacio()) { // L
            int clave = claves.elegir(); // C
            claves.sacar(clave); // L

            ConjuntoTDA valores = dic.recuperar(clave); // L

            while (!valores.conjuntoVacio()) { // L
                int valor = valores.elegir(); // C
                valores.sacar(valor); // L

                if (!valoresAgregados.pertenece(valor)) { // L
                    cola.acolar(valor); // L
                    valoresAgregados.agregar(valor); // L
                }
            }
        }

        return cola; // C
    } // P
}
