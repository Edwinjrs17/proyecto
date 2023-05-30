/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author edwin
 */
public class manejo_citas {
    private int id_paciente;
    private String medico;
    private String regimen;
    private String ubicacion;
    private String especialidad;
    private String tipo_control;

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTipo_control() {
        return tipo_control;
    }

    public void setTipo_control(String tipo_control) {
        this.tipo_control = tipo_control;
    }
    
    public manejo_citas(){
    }
    
    public manejo_citas(int id,String medico, String regimen, String ubicacion, String especialidad, String tipo_control){
        this.id_paciente = id;
        this.medico = medico;
        this.regimen = regimen;
        this.ubicacion = ubicacion;
        this.especialidad = especialidad;
        this.tipo_control = tipo_control;
    }
}
