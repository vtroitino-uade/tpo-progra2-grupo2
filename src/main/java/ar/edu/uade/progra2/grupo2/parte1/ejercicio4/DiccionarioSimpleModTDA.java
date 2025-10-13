package ar.edu.uade.progra2.grupo2.parte1.ejercicio4;
import tda.ConjuntoTDA;

public interface DiccionarioSimpleModTDA {
    void inicializarDiccionario();
    void agregar(int clave, int valor);
    void eliminar(int clave);
    int recuperar(int clave);
    int recuperarMod(int clave);
    ConjuntoTDA claves();
}