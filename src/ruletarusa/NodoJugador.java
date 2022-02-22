/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ruletarusa;


public class NodoJugador {
    private Jugador jugador;
    private NodoJugador siguiente;
    
    public NodoJugador(){
        jugador = null;
        siguiente = null;
    }
    
    public NodoJugador(String cedula, String nombreCompleto, int edad){
        jugador = new Jugador(cedula, nombreCompleto, edad);
        siguiente = null;
    }
    
    public NodoJugador(Jugador jug) {
        jugador = jug;
        siguiente = null;
    }
    
    public NodoJugador(Jugador jug, NodoJugador sig){
        jugador = jug;
        siguiente = sig;
    }
    
    public void setSiguiente(NodoJugador sig){
        siguiente = sig;
    }
    
    public void setJugador(Jugador jug) {
        jugador = jug;
    }
   
    
    public Jugador getJugadador(){
        return jugador;
    }
    
    
    public NodoJugador getSiguiente() {
        return siguiente;
    }
}
