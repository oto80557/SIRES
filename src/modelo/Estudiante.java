/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author aaron
 */
public class Estudiante {
    private String nombre;
    private int edad;
    private String carnet;

    public Estudiante( String nombre, int edad, String carnet) {
       
        this.nombre = nombre;
        this.edad = edad;
        this.carnet = carnet;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

   
    public String getInformacion() {
       
        return this.getCarnet() + "\t" +this.getNombre()+"\t"+this.getEdad()+"\t";
    }
    
    
}
