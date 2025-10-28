package ar.edu.uade.progra2.grupo2.parte1.ejercicio2;

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
        c = null;
    }

    @Override
    public boolean estaVacio() {
        return c == null;
    }

    @Override
    public void guardar(int dato) {
        c = new Nodo(dato, c);
    }

    @Override
    public int elegir() {
        if (c == null) throw new IllegalStateException("El conjunto está vacío");
        return c.valor;
    }

    @Override
    public int perteneceCant(int dato) {
        Nodo aux = c;
        int cont = 0;
        while (aux != null) {
            if (aux.valor == dato) cont++;
            aux = aux.sig;
        }
        return cont;
    }

    @Override
    public void sacar(int dato) {
        if (c == null) return; 

        
        if (c.valor == dato) {
            c = c.sig;
            return;
        }

        Nodo aux = c;
        while (aux.sig != null && aux.sig.valor != dato) {
            aux = aux.sig;
        }

        
        if (aux.sig != null) {
            aux.sig = aux.sig.sig;
        }
    }
}
