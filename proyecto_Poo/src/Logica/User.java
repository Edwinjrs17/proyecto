package Logica;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author edwin
 */
public class User {
    private String nombre = "";
    private int cedula = 0;
    private int celular = 0;
    private String direccion = "";
   
    private String cumpleaños;
    private String email;
    private String control;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getCumpleaños() {
        return cumpleaños;
    }

    public void setCumpleaños(String cumpleaños) {
        this.cumpleaños = cumpleaños;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getControl() {
        return control;
    }

    public void setContraseña(String control) {
        this.control = control;
    }

    public User() {
    }

    public User(String nombre,int cedula, int celular,String direccion, String cumpleaños, String email, String control ) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.celular = celular;
        this.direccion = direccion;
        this.cumpleaños = cumpleaños;
        this.email = email;
        this.control = control;

    }
    
    
    
    
}
