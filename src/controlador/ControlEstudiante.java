/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import modelo.RegistroEstudiante;
import vista.GUIEstudiante;
import vista.GUIReporte;
import vista.PanelBotones;
import vista.PanelEstudiante;

/**
 *
 * @author Héctor
 */
public class ControlEstudiante implements ActionListener {

    private RegistroEstudiante registroEstudiante;
    private PanelEstudiante panelData;
    private PanelBotones panelBtn;

    public ControlEstudiante(PanelEstudiante panelEstudiante, PanelBotones panelBtn, RegistroEstudiante registroEstudiante, GUIEstudiante guiEstudiante) {
        registroEstudiante = new RegistroEstudiante();
        this.registroEstudiante = registroEstudiante;
        guiEstudiante = new GUIEstudiante(registroEstudiante);
        this.panelData = panelEstudiante;
        this.panelBtn = panelBtn;
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotones.BTN_AGREGAR)) {
            if (panelData.getTxtCarnet().equalsIgnoreCase("")) {

                GUIEstudiante.mensaje("El campo carnet no tiene información, por favaor agregue el carnet del estudiante");

            } else if (panelData.getTxtNombre().equalsIgnoreCase("")) {
                GUIEstudiante.mensaje("El campo nombre no tiene información, por favaor agregue el nombre del estudiante");
            } else if (panelData.getTxtEdad() == 0) {
                GUIEstudiante.mensaje("El campo edad no tiene información, por favaor agregue el edad del estudiante");
            } else {
                GUIEstudiante.mensaje(registroEstudiante.addEstudiante(new Estudiante(panelData.getTxtNombre(), panelData.getTxtEdad(), panelData.getTxtCarnet())));
                panelData.limpiar();

            }
        }//Fin del if BTN_AGREGAR
        
        if (evento.getActionCommand().equalsIgnoreCase(PanelEstudiante.BTN_BUSCAR)) {
          Estudiante estudiante = registroEstudiante.consultar(panelData.getTxtCarnet());
          if(estudiante != null){
              
          panelData.setTxtCarnet(estudiante.getCarnet());
          panelData.setTxtNombre(estudiante.getNombre());
          panelData.setTxtEdad(estudiante.getEdad());
          panelBtn.enableEliMod(true);
          
          }else{
              GUIEstudiante.mensaje("El estudiante no se encuantra registrado");
              panelData.limpiar();
          }
        }//Fin del evento buscar
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotones.BTN_ELIMINAR)){
            Estudiante estudianteEliminar = new Estudiante(panelData.getTxtNombre(), panelData.getTxtEdad(), panelData.getTxtCarnet());
            GUIEstudiante.mensaje(registroEstudiante.deleteEstudiante(estudianteEliminar));
            panelData.limpiar();
            panelBtn.enableEliMod(false);
        }//Fin del evento eliminar
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotones.BTN_MODIFICAR)){
            Estudiante estudianteModificar = new Estudiante(panelData.getTxtNombre(), panelData.getTxtEdad(), panelData.getTxtCarnet());
            GUIEstudiante.mensaje(registroEstudiante.modificarEstudiante(estudianteModificar));
            panelData.limpiar();
        }

        if (evento.getActionCommand().equalsIgnoreCase(PanelBotones.BTN_CONSULTAR)) {
            GUIReporte guiReporte = new GUIReporte();
            guiReporte.setVisible(true);
            guiReporte.setTxaReporte(registroEstudiante.consultarAll());
        }

        if (evento.getActionCommand().equalsIgnoreCase(PanelBotones.BTN_SALIR)) {
            System.exit(0);
        }
    }//FIN DE SALIR

}
