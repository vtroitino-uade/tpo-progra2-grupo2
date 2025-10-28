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
        c = null;    
        
    }

    @Override
    public Respuesta agregar(int x) {
        if(pertenece(x)){
            Respuesta error = new Respuesta(true, x);
            return error; 
        }

        Nodo aux = new Nodo(x, c);
        c = aux;

        return new Respuesta(false, x);
    }

    @Override
    public boolean conjuntoVacio() {
        return (c == null);
    }

    @Override
    public Respuesta elegir() {
        if (c == null){
            return new Respuesta(true, 0);
        }
        
        return new Respuesta(false, c.valor);
        
    }

    

    @Override
    public boolean pertenece(int x) {
        Nodo aux = c;
        while (aux != null && aux.valor != x){
            aux = aux.sig;
        }
        return (aux != null);
    }

    @Override
    public Respuesta sacar(int x) {
        if (conjuntoVacio()){
            return new Respuesta(true, x);
        }

        if (c.valor == x){
            c = c.sig;
            return new Respuesta(false, x);
        }

        Nodo aux = c;
        while (!(aux.sig != null && aux.sig.valor != x)){
            aux = aux.sig;
        }
        if(aux.sig == null){
            return new Respuesta(true, x);
        }else{
            aux.sig = aux.sig.sig;
            return new Respuesta(false, x);
        }
        
    }

}
