/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ruletarusa;


public class Jugador {
    Persona datosPersonales;
    Pistola arma;
    int rondasGanadas;
    
    public Jugador(String cedula, String nombreCompleto, int edad){
        datosPersonales = new Persona(cedula, nombreCompleto, edad);
        arma = new Pistola();
        rondasGanadas = 0;
    }
    
    public void aumentarContadorRondas(){
        rondasGanadas++;
    }
    
    public boolean jugar() {
        return arma.disparar();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(datosPersonales.toString()).append("Numero de rondas jugadas: ").append(rondasGanadas).append("\n");
        return sb.toString();
    }
}
