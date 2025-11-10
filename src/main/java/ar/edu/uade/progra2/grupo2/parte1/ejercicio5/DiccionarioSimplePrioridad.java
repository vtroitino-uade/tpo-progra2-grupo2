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
        datos = new ColaPrioridad(); // C
        datos.inicializarCola(); // C
    } // C

    @Override
    public void agregar(int clave, int valor) {
        // Costo: Lineal (O(n))

        ColaPrioridadTDA aux = new ColaPrioridad(); // C
        aux.inicializarCola(); // C
        boolean reemplazado = false; // C

        while (!datos.colaVacia()) { // L
            int v = datos.primero(); // C
            int c = datos.prioridad(); // C
            datos.desacolar(); // C

            if (c == clave) { // C
                aux.acolarPrioridad(valor, clave); // C // reemplazo el valor
                reemplazado = true; // C
            } else {
                aux.acolarPrioridad(v, c); // C
            }
        }

        if (!reemplazado) { // C
            aux.acolarPrioridad(valor, clave); // C
        }

        // Restaurar la cola original
        while (!aux.colaVacia()) { // L
            datos.acolarPrioridad(aux.primero(), aux.prioridad()); // C
            aux.desacolar(); // C
        }
    } // L

    @Override
    public void eliminar(int clave) {
        // Costo: Lineal (O(n))

        ColaPrioridadTDA aux = new ColaPrioridad(); // C
        aux.inicializarCola(); // C

        while (!datos.colaVacia()) { // L
            int v = datos.primero(); // C
            int c = datos.prioridad(); // C
            datos.desacolar(); // C

            if (c != clave) { // C
                aux.acolarPrioridad(v, c); // C
            }
        }

        while (!aux.colaVacia()) { // L
            datos.acolarPrioridad(aux.primero(), aux.prioridad()); // C
            aux.desacolar(); // C
        }
    } // L

    @Override
    public int recuperar(int clave) {
        // Costo: Lineal (O(n))

        ColaPrioridadTDA aux = new ColaPrioridad(); // C
        aux.inicializarCola(); // C
        int valor = -1; // C

        while (!datos.colaVacia()) { // L
            int v = datos.primero(); // C
            int c = datos.prioridad(); // C

            if (c == clave) { // C
                valor = v; // C
            }

            aux.acolarPrioridad(v, c); // C
            datos.desacolar(); // C
        }

        // restaurar
        while (!aux.colaVacia()) { // L
            datos.acolarPrioridad(aux.primero(), aux.prioridad()); // C
            aux.desacolar(); // C
        }

        return valor; // C
    } // L

    @Override
    public ConjuntoTDA claves() {
        // Costo: Lineal (O(n))

        ConjuntoTDA c = new Conjunto(); // C
        c.inicializarConjunto(); // C

        ColaPrioridadTDA aux = new ColaPrioridad(); // C
        aux.inicializarCola(); // C

        while (!datos.colaVacia()) { // L
            int v = datos.primero(); // C
            int clave = datos.prioridad(); // C
            c.agregar(clave); // C
            aux.acolarPrioridad(v, clave); // C
            datos.desacolar(); // C
        }

        // restaurar la cola
        while (!aux.colaVacia()) { // L
            datos.acolarPrioridad(aux.primero(), aux.prioridad()); // C
            aux.desacolar(); // C
        }

        return c; // C
    } // L
}
