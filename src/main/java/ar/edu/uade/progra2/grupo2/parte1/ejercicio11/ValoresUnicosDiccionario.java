package ar.edu.uade.progra2.grupo2.parte1.ejercicio11;

import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;
import imple.Cola;
import imple.Conjunto;

public class ValoresUnicosDiccionario {

    public static ColaTDA obtener(DiccionarioMultipleTDA dic) {
        ColaTDA cola = new Cola();
        cola.inicializarCola();

        ConjuntoTDA claves = dic.claves();
        ConjuntoTDA valoresAgregados = new Conjunto();
        valoresAgregados.inicializarConjunto();

        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            claves.sacar(clave);

            ConjuntoTDA valores = dic.recuperar(clave);

            while (!valores.conjuntoVacio()) {
                int valor = valores.elegir();
                valores.sacar(valor);

                if (!valoresAgregados.pertenece(valor)) {
                    cola.acolar(valor);
                    valoresAgregados.agregar(valor);
                }
            }
        }

        return cola;
    }
}
