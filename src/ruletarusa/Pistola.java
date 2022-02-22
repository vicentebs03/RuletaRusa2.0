/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ruletarusa;


public class Pistola {
    private int[] balas = {1,0,0,0,0,0};
    public Pistola() {
        mezclarBalas();
    }
    public void mezclarBalas(){
        int temporal;
        int posicionAleatoria;
        for (int i = 0; i < balas.length; i++) {
            posicionAleatoria = (int)(Math.random()*6);
            temporal = balas[posicionAleatoria];
            balas[posicionAleatoria] = balas[i];
            balas[i] = temporal;
        }
    }
    
    public boolean disparar() {
        int posicion = (int)(Math.random()*6);
        boolean resultado = balas[posicion] == 1;
        mezclarBalas();
        return resultado;
    }
    
    public static void main(String[] args) {
        Pistola gun = new Pistola();
        Pistola anotherGun = new Pistola();
    }
}
