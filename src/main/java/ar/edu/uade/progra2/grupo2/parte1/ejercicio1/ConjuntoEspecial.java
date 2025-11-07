package ar.edu.uade.progra2.grupo2.parte1.ejercicio1;


public class ConjuntoEspecial implements ConjuntoEspecialTDA {
    private class Nodo{
        int valor;
        Nodo sig;

        public Nodo(int valor, Nodo sig){
            this.valor = valor;
            this.sig = sig;
        }
    }

    private Nodo c;

    @Override
    public void inicializarConjunto() {
        c = null; // C
    } // C

    @Override
    public Respuesta agregar(int x) {
        if(pertenece(x)){ // L
            Respuesta error = new Respuesta(true, x); // C
            return error;  // C
        }

        Nodo aux = new Nodo(x, c); // C
        c = aux; // C

        return new Respuesta(false, x); // C
    } // L

    @Override
    public boolean conjuntoVacio() {
        return (c == null); // C
    } // C

    @Override
    public Respuesta elegir() {
        if (c == null){ // C
            return new Respuesta(true, 0); // C
        }
        
        return new Respuesta(false, c.valor); // C
        
    } // C

    

    @Override
    public boolean pertenece(int x) {
        Nodo aux = c; // C
        while (aux != null && aux.valor != x){ // L
            aux = aux.sig; // C
        }
        return (aux != null); // C
    } // L

    @Override
    public Respuesta sacar(int x) {
        if (conjuntoVacio()){ // C
            return new Respuesta(true, x); // C
        }

        if (c.valor == x){ // C
            c = c.sig; // C
            return new Respuesta(false, x); // C
        }

        Nodo aux = c; // C
        while (!(aux.sig != null && aux.sig.valor != x)){ // L
            aux = aux.sig; // C
        }
        if(aux.sig == null){ // C
            return new Respuesta(true, x); // C
        }else{
            aux.sig = aux.sig.sig; // C
            return new Respuesta(false, x); // C
        }
        
    } // L

}
