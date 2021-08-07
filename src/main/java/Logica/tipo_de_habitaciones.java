/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

/**
 *
 * @author fvg
 */
public class tipo_de_habitaciones implements Serializable {
    @Id
    private int id;
    @Basic
    private String descripcion;
    @Basic
    private int cantidad_personas_maxima;

    public tipo_de_habitaciones(int id, String descripcion, int cantidad_personas_maxima) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad_personas_maxima = cantidad_personas_maxima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad_personas_maxima() {
        return cantidad_personas_maxima;
    }

    public void setCantidad_personas_maxima(int cantidad_personas_maxima) {
        this.cantidad_personas_maxima = cantidad_personas_maxima;
    }
    
    
    
}