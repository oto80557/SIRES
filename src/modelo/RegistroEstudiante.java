/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author aaron
 */
public class RegistroEstudiante {

    ArrayList<Estudiante> listaEstudiante;

    public RegistroEstudiante() {
        listaEstudiante = new ArrayList<Estudiante>();
    }

    public String addEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            if (verificarCarnet(estudiante.getCarnet())) {
                listaEstudiante.add(estudiante);
                return "El estudiante fue agregado correctamente";
            } else {
                return "El estudiante se encuentra registrado!";
            }
        }
        return "El objeto es null!";
    }

    public boolean verificarCarnet(String carnet) {
        if (!carnet.equalsIgnoreCase("")) {
            if (listaEstudiante.size() != 0) {
                for (int index = 0; index < listaEstudiante.size(); index++) {
                    if (listaEstudiante.get(index).getCarnet().equals(carnet)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Estudiante consultar(String carnet) {

        for (Estudiante estudiante : listaEstudiante) {
            if (estudiante.getCarnet().equalsIgnoreCase(carnet)) {
               
                return estudiante;
            }
        }

        return null;
    }
    
    public String consultarAll(){
        String salida="Carnet\t"+"Nombre\t\t"+"Edad\n";
        for (Estudiante estudiante : listaEstudiante) {
            salida+=estudiante.getInformacion()+"\n";
        }
        return salida;
    }
    
    /*public String eliminar(String carnet) {

        String mensaje = "Aún no se han eliminado estudiantes";

        if (!carnet.equalsIgnoreCase("")) {
            for (int index = 0; index < listaEstudiante.size(); index++) {
                if (listaEstudiante.get(index) != null) {
                    if (listaEstudiante.get(index).getCarnet().equals(carnet)) {

                        listaEstudiante.remove(index);
                        mensaje = "El estudiante fue eliminado correctamente";

                    }
                }
            }
        }
        return mensaje;
    }*/
    
    public String deleteEstudiante(Estudiante estudiante){
        for(int i = 0; i < listaEstudiante.size(); i++){
            if(estudiante.getCarnet().equalsIgnoreCase(estudiante.getCarnet())){
                listaEstudiante.remove(i);
                return "El estudiante fue eliminado correctamente";
            }
        }
        return "El proceso de eliminar no fue exitoso";
    }
    
    public String modificarEstudiante(Estudiante estudiante){
        for(int i = 0; i < listaEstudiante.size(); i ++){
            if(estudiante.getCarnet().equalsIgnoreCase(estudiante.getCarnet())){
                listaEstudiante.add(i, estudiante);
                return "El estudiante fue modificado";
            }
        }
        return "El proceso de modificar no fue exitoso";
    }

}
