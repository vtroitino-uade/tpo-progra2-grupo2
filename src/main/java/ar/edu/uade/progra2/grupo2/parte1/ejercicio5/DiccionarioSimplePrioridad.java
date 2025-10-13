package ar.edu.uade.progra2.grupo2.parte1.ejercicio5;

import imple.ColaPrioridad;
import tda.ColaPrioridadTDA;
import tda.ConjuntoTDA;
import imple.Conjunto;
import tda.DiccionarioSimpleTDA;

/**
 *
 * Estrategia:
 * Se implementa un DiccionarioSimpleTDA utilizando únicamente
 * una ColaPrioridadTDA interna.
 * 
 */
public class DiccionarioSimplePrioridad implements DiccionarioSimpleTDA {

    private ColaPrioridadTDA datos;

    @Override
    public void inicializarDiccionario() {
        // Costo: Constante
        datos = new ColaPrioridad();
        datos.inicializarCola();
    }

    @Override
    public void agregar(int clave, int valor) {
        // Costo: Lineal (O(n))

        ColaPrioridadTDA aux = new ColaPrioridad();
        aux.inicializarCola();
        boolean reemplazado = false;

        while (!datos.colaVacia()) {
            int v = datos.primero();
            int c = datos.prioridad();
            datos.desacolar();

            if (c == clave) {
                aux.acolarPrioridad(valor, clave); // reemplazo el valor
                reemplazado = true;
            } else {
                aux.acolarPrioridad(v, c);
            }
        }

        if (!reemplazado) {
            aux.acolarPrioridad(valor, clave);
        }

        // Restaurar la cola original
        while (!aux.colaVacia()) {
            datos.acolarPrioridad(aux.primero(), aux.prioridad());
            aux.desacolar();
        }
    }

    @Override
    public void eliminar(int clave) {
        // Costo: Lineal (O(n))

        ColaPrioridadTDA aux = new ColaPrioridad();
        aux.inicializarCola();

        while (!datos.colaVacia()) {
            int v = datos.primero();
            int c = datos.prioridad();
            datos.desacolar();

            if (c != clave) {
                aux.acolarPrioridad(v, c);
            }
        }

        while (!aux.colaVacia()) {
            datos.acolarPrioridad(aux.primero(), aux.prioridad());
            aux.desacolar();
        }
    }

    @Override
    public int recuperar(int clave) {
        // Costo: Lineal (O(n))

        ColaPrioridadTDA aux = new ColaPrioridad();
        aux.inicializarCola();
        int valor = -1;

        while (!datos.colaVacia()) {
            int v = datos.primero();
            int c = datos.prioridad();

            if (c == clave) {
                valor = v;
            }

            aux.acolarPrioridad(v, c);
            datos.desacolar();
        }

        // restaurar
        while (!aux.colaVacia()) {
            datos.acolarPrioridad(aux.primero(), aux.prioridad());
            aux.desacolar();
        }

        if (valor == -1) {
            throw new IllegalArgumentException("Clave inexistente: " + clave);
        }

        return valor;
    }

    @Override
    public ConjuntoTDA claves() {
        // Costo: Lineal (O(n))

        ConjuntoTDA c = new Conjunto();
        c.inicializarConjunto();

        ColaPrioridadTDA aux = new ColaPrioridad();
        aux.inicializarCola();

        while (!datos.colaVacia()) {
            int v = datos.primero();
            int clave = datos.prioridad();
            c.agregar(clave);
            aux.acolarPrioridad(v, clave);
            datos.desacolar();
        }

        // restaurar la cola
        while (!aux.colaVacia()) {
            datos.acolarPrioridad(aux.primero(), aux.prioridad());
            aux.desacolar();
        }

        return c;
    }
}
