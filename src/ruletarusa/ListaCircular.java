/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ruletarusa;


public class ListaCircular {
    private NodoJugador cabeza;
    private NodoJugador cola;
    public int tamaño = 0;
    
    public ListaCircular(){
        cabeza = null;
        cola = null;
        tamaño = 0;
    }
    
    public void vaciar() {
        cabeza = null;
        cola = null;
        tamaño = 0;
    }
    
    public boolean esVacio(){
        return cabeza == null;
    }
    
    public int getTamaño(){
        return tamaño;
    }
    
    public NodoJugador getCabeza() {
        return cabeza;
    }
    
    public void insertarInicio(Jugador jug){
        NodoJugador nuevoNodo = new NodoJugador(jug);
        nuevoNodo.setSiguiente(cabeza);
        if(cabeza==null){
            cabeza = nuevoNodo;
            nuevoNodo.setSiguiente(cabeza);
            cola = cabeza;
        } else {
            cola.setSiguiente(nuevoNodo);
            cabeza = nuevoNodo;
        }
        tamaño++;
    }
    
    public void insertarFinal(Jugador jug){
        NodoJugador nuevoNodo = new NodoJugador(jug);
        nuevoNodo.setSiguiente(cabeza);
        if(cabeza==null){
            cabeza = nuevoNodo;
            nuevoNodo.setSiguiente(cabeza);
            cola = cabeza;
        } else {
            cola.setSiguiente(nuevoNodo);
            cola = nuevoNodo;
        }
        tamaño++;
    }
    
    public void eliminarPosición(int posición) {
        if(tamaño==1 && posición == 1) {
            vaciar();
            return;
        }
        
        if (posición==1){
            cabeza = cabeza.getSiguiente();
            cola.setSiguiente(cabeza);
            tamaño--;
            return;
        }
        
        if (posición == tamaño) {
            NodoJugador puntero1 = cabeza;
            NodoJugador puntero2 = cabeza;
            while (puntero1 != cola) {
                puntero2 = puntero1;
                puntero1 = puntero1.getSiguiente();
            }
            cola = puntero2;
            cola.setSiguiente(cabeza);
            tamaño--;
            return;
        }
        
        NodoJugador puntero = cabeza;
        int contador = posición - 1;
        for (int i = 1; i < tamaño-1; i++) {
            if(i == contador){
                NodoJugador temporal = puntero.getSiguiente();
                temporal = temporal.getSiguiente();
                puntero.setSiguiente(temporal);
                break;
            }
            puntero = puntero.getSiguiente();
        }
        tamaño--;
    }
    
    public void eliminarID(String ID) {
        if (cabeza == null) {
            return;
        }
        NodoJugador puntero1 = cabeza;
        NodoJugador puntero2 = new NodoJugador();
        while(!(puntero1.getJugadador().datosPersonales.getCedula().equals(ID))) {
            if (puntero1.getSiguiente()==cabeza){
                System.out.println("Nodo no encontrado.");
                break;
            }
            puntero2 = puntero1;
            puntero1 = puntero1.getSiguiente();
        }
        if(puntero1==cabeza && puntero1.getSiguiente()==cabeza) {
            vaciar();
        }
        if(puntero1==cabeza) {
            puntero2 = cabeza;
            while(puntero2.getSiguiente()!=cabeza){
                puntero2=puntero2.getSiguiente();
            }
            cabeza=puntero1.getSiguiente();
            puntero2.setSiguiente(cabeza);
            tamaño--;
        } else if (puntero1.getSiguiente() == cabeza){
            puntero2.setSiguiente(cabeza);
            tamaño--;
        } else {
            puntero2.setSiguiente(puntero1.getSiguiente());
            tamaño--;
        }
        
    }
}
