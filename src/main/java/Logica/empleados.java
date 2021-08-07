/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
/**
 *
 * @author fvg
 */
public class empleados implements Serializable {
    @Id
    private Integer id;
    @Basic
    private String dni;
    @Basic
    private String nombre;
    @Basic
    private String apellido;
    @Temporal(TemporalType.DATE)
    private Date fecha_de_nacimiento;
    @Basic
    private String direccion;
    @Basic
    private String cargo;
    @Basic
    private String nombre_usuario;
    @Basic
    private String contrasenia_usuario;

    public empleados(Integer id, String dni, String nombre, String apellido, Date fecha_de_nacimiento, String direccion, String cargo, String nombre_usuario, String contrasenia_usuario) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.direccion = direccion;
        this.cargo = cargo;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia_usuario = contrasenia_usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia_usuario() {
        return contrasenia_usuario;
    }

    public void setContrasenia_usuario(String contrasenia_usuario) {
        this.contrasenia_usuario = contrasenia_usuario;
    }


    
    
}
