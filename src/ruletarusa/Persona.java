/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ruletarusa;


public class Persona {
    private String cedula;
    private String nombreCompleto;
    private int edad;
    
    public Persona(String ced, String nom, int ed){
        cedula = ced;
        nombreCompleto = nom;
        edad = ed;
    }
    
    public void setCedula(String ced) {
        cedula = ced;
    }
    
    public void setNombre(String nom){
        nombreCompleto = nom;
    }
    
    public void setEdad(int ed) {
        edad = ed;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public String getNombre(){
        return nombreCompleto;
    }
    
    public String getCedula(){
        return cedula;
    }
    
    
    
    
}
