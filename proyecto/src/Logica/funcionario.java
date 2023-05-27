/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;


/**
 *
 * @author edwin
 */
public class funcionario {
    private String nombre = "";
    private int cedula = 0;
    private int celular = 0;
    private String funcion = "";
    private String fecha;
    private String email;
    private String contraseña;

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

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public funcionario(){}

    public funcionario(String nombre,int celular,int cedula,String funcion,String fecha, String email, String contraseña) {
        this.nombre = nombre;
        this.celular = celular;
        this.cedula = cedula;
        this.funcion = funcion;
        this.fecha = fecha;
        this.email = email;
        this.contraseña = contraseña;
    }
    
    
    
}
