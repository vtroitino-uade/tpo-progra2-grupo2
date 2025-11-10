package ar.edu.uade.progra2.grupo2.parte1.ejercicio2.implementacion;

import ar.edu.uade.progra2.grupo2.parte1.ejercicio2.interfaz.ConjuntoMamushkaTDA;

public class ConjuntoMamushka implements ConjuntoMamushkaTDA {
    private class Nodo {
        int valor;
        Nodo sig;

        Nodo(int valor, Nodo sig) {
            this.valor = valor;
            this.sig = sig;
        }
    }

    private Nodo c;

    @Override
    public void inicializar() {
        c = null; // C
    } // C

    @Override
    public boolean estaVacio() {
        return c == null; // C
    } // C

    @Override
    public void guardar(int dato) {
        c = new Nodo(dato, c); // C
    } // C

    @Override
    public int elegir() {
        if (c == null) throw new IllegalStateException("El conjunto está vacío"); // C
        return c.valor; // C
    } // C

    @Override
    public int perteneceCant(int dato) {
        Nodo aux = c; // C
        int cont = 0; // C
        while (aux != null) { // L
            if (aux.valor == dato) cont++; // C
            aux = aux.sig; // C
        }
        return cont; // C
    } // L

    @Override
    public void sacar(int dato) {
        if (c == null) return;  // C

        
        if (c.valor == dato) { // C
            c = c.sig; // C
            return; // C
        }

        Nodo aux = c; // C
        while (aux.sig != null && aux.sig.valor != dato) { // L
            aux = aux.sig; // C
        }

        
        if (aux.sig != null) { // C
            aux.sig = aux.sig.sig; // C
        }
    } // L
}
