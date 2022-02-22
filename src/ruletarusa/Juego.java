/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruletarusa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Juego {

    ListaCircular jugadores;
    LinkedList<Jugador> eliminados;
    LinkedList<String> cedulaEliminados;
    Jugador ganador;
    boolean huboGanador = false;

    public Juego(File f) {
        jugadores = new ListaCircular();
        eliminados = new LinkedList<>();
        cedulaEliminados = new LinkedList<>();
        ganador = null;
        String[] placeholder = new String[3];
        try {
            Scanner scan = new Scanner(f);
            while (scan.hasNextLine()) {
                placeholder = scan.nextLine().split(" ");
                placeholder[1] = placeholder[1].replace('_', ' ');
                jugadores.insertarFinal(new Jugador(placeholder[0], placeholder[1], Integer.parseInt(placeholder[2])));
            }
        } catch (FileNotFoundException ex) {
            
        }
    }

    public Juego jugar() {
        NodoJugador puntero;
        while (!jugadores.esVacio() && jugadores.tamaño != 1) {
            puntero = jugadores.getCabeza();
            puntero.getJugadador().aumentarContadorRondas();
            if (puntero.getJugadador().jugar()) {
                if (puntero.getSiguiente().equals(jugadores.getCabeza())) {
                    cedulaEliminados.add(jugadores.getCabeza().getJugadador().datosPersonales.getCedula());
                    eliminados.add(jugadores.getCabeza().getJugadador());
                    
                } else {
                    cedulaEliminados.add(puntero.getSiguiente().getJugadador().datosPersonales.getCedula());
                    eliminados.add(puntero.getSiguiente().getJugadador());
                }
            }
            puntero = puntero.getSiguiente();
            while (!(puntero.equals(jugadores.getCabeza()))) {
                puntero.getJugadador().aumentarContadorRondas();
                if (puntero.getJugadador().jugar()) {
                    if (puntero.getSiguiente().equals(jugadores.getCabeza())) {
                        cedulaEliminados.add(jugadores.getCabeza().getJugadador().datosPersonales.getCedula());
                        eliminados.add(jugadores.getCabeza().getJugadador());
                       
                    } else {
                        cedulaEliminados.add(puntero.getSiguiente().getJugadador().datosPersonales.getCedula());
                        eliminados.add(puntero.getSiguiente().getJugadador());
                    }
                }
                puntero = puntero.getSiguiente();
            }

            if (!cedulaEliminados.isEmpty()) {
                for (String e : cedulaEliminados) {
                    jugadores.eliminarID(e);
                }
            }
            cedulaEliminados.clear();
        }

        if (jugadores.esVacio()) {
            huboGanador = false;
        } else {
            ganador = jugadores.getCabeza().getJugadador();
            huboGanador = true;
        }
        
        return this;
    }
    
    public boolean huboGanador(){
        return huboGanador;
    }
    
    public Jugador getGanador(){
        return ganador;
    }
    
    public LinkedList<Jugador> getPerdedores(){
        return eliminados;
    }
}
