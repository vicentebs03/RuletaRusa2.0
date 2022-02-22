/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruletarusa;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RuletaRusa {

    public static void main(String[] args) {
        File archGanador = new File("./ganador.out");
        File archPerdedores = new File("./Derrotados.out");
        File archivoEntrada = new File("./jugadores.in");

        String selección = "";
        Scanner scan = new Scanner(System.in);
        while (true) {
            selección = menu(scan);
            if (selección.equals("0") || selección.equals("1")) {
                break;
            }
        }

        if (selección.equals("1")) {
            PreparadorJuego pj = new PreparadorJuego();
            if (pj.verificarEntrada(archivoEntrada)) {
                
                 Juego juego = new Juego(archivoEntrada);
                juego.jugar();
                ManejadorDeSalida man = new ManejadorDeSalida(juego);
                try {
                    man.imprimirGanador(archGanador);
                } catch (IOException ex) {
                    System.out.println("No se pudo escribir al archivo de ganadores.");
                }
                try {
                    man.imprimirPerdedores(archPerdedores);
                } catch (IOException ex) {
                    System.out.println("No se pudo imprimir al arhivo de perdedores.");
                }
                System.out.println("Se han escrito los archivos satisfactoriamente");
            } else {
                System.out.println("Imposible iniciar el juego. Saliendo.");
            }
        }

    }

    public static String menu(Scanner scan) {
        System.out.println("JUGAR A LA RULETA RUSA");
        System.out.println("");
        System.out.println("1. Cargar parámetros del archivo de entrada y jugar automáticamente.");
        System.out.println("0. Salir.");
        System.out.println("");
        System.out.print("Selección: ");
        return scan.nextLine();
    }
}
