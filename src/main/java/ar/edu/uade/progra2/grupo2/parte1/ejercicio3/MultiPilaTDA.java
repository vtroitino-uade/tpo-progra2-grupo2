package ar.edu.uade.progra2.grupo2.parte1.ejercicio3;

import tda.PilaTDA;

public interface MultiPilaTDA {
    public void apilar (PilaTDA valores); 

    public void desapilar (PilaTDA valores); 

    public PilaTDA tope (int cantidad); 
    public void inicializarPila(); 
    public boolean pilaVacia();
}
