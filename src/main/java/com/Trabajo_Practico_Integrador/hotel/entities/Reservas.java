/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Trabajo_Practico_Integrador.hotel.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
/**
 *
 * @author fvg
 */
public class Reservas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date fecha_check_in;
    @Temporal(TemporalType.DATE)
    private Date fecha_check_out;
    @Basic
    private int empleado_id;
    @Basic
    private int habitacion_id;
    @Basic
    private int cantidad_personas;
    @Basic
    private int huesped_id;

    public Reservas(Integer id, Date fecha_check_in, Date fecha_check_out, int empleado_id, int habitacion_id, int cantidad_personas, int huesped_id) {
        this.id = id;
        this.fecha_check_in = fecha_check_in;
        this.fecha_check_out = fecha_check_out;
        this.empleado_id = empleado_id;
        this.habitacion_id = habitacion_id;
        this.cantidad_personas = cantidad_personas;
        this.huesped_id = huesped_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha_check_in() {
        return fecha_check_in;
    }

    public void setFecha_check_in(Date fecha_check_in) {
        this.fecha_check_in = fecha_check_in;
    }

    public Date getFecha_check_out() {
        return fecha_check_out;
    }

    public void setFecha_check_out(Date fecha_check_out) {
        this.fecha_check_out = fecha_check_out;
    }

    public int getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
    }

    public int getHabitacion_id() {
        return habitacion_id;
    }

    public void setHabitacion_id(int habitacion_id) {
        this.habitacion_id = habitacion_id;
    }

    public int getCantidad_personas() {
        return cantidad_personas;
    }

    public void setCantidad_personas(int cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    }

    public int getHuesped_id() {
        return huesped_id;
    }

    public void setHuesped_id(int huesped_id) {
        this.huesped_id = huesped_id;
    }
    
    
    
}
