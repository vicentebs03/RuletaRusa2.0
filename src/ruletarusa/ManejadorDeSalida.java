/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ruletarusa;

import java.io.File;
import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException;


public class ManejadorDeSalida {
    Jugador ganador;
    boolean huboGanador;
    LinkedList<Jugador> perdedores;
    
    public ManejadorDeSalida(Juego juego){
        if (juego.huboGanador()){
            huboGanador = true;
            ganador = juego.getGanador();
        }
        perdedores = juego.getPerdedores();
    }
    
    public void imprimirGanador(File archivoGanador) throws IOException{
       
        //crear archivo de salida
        if(archivoGanador.createNewFile()) {
            System.out.println("Archivo de ganador creado. Llenando...");
        } else {
            System.out.println("Archivo de ganador ya existente. Sobrescribiendo...");
            archivoGanador.delete();
            archivoGanador.createNewFile();
        }
         FileWriter fw = new FileWriter(archivoGanador);
        if(huboGanador){
            fw.write(ganador.toString());
        } else {
            fw.write("No hubo un ganador. Los jugadores restantes perdieron al mismo tiempo.");
        }    
        fw.close();
    }
    
    
    public void imprimirPerdedores(File archivoPerdedores) throws IOException{
        
            if(archivoPerdedores.createNewFile()) {
            System.out.println("Archivo de perdedores creado. Llenando...");
        } else {
            System.out.println("Archivo de perdedores ya existente. Sobrescribiendo...");
            archivoPerdedores.delete();
            archivoPerdedores.createNewFile();
        }
        FileWriter fw = new FileWriter(archivoPerdedores);
        for(Jugador e:perdedores){
            fw.write(e.toString());
            fw.write(System.getProperty("line.separator"));
        }
        fw.close();
        }
    }

