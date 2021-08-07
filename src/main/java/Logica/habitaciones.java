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
public class habitaciones implements Serializable {
    @Id
    private Integer id;
    @Basic
    private String piso;
    @Basic
    private String nombre;
    @Basic
    private int tipo_de_habitacion_id;

    public habitaciones(Integer id, String piso, String nombre, int tipo_de_habitacion_id) {
        this.id = id;
        this.piso = piso;
        this.nombre = nombre;
        this.tipo_de_habitacion_id = tipo_de_habitacion_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo_de_habitacion_id() {
        return tipo_de_habitacion_id;
    }

    public void setTipo_de_habitacion_id(int tipo_de_habitacion_id) {
        this.tipo_de_habitacion_id = tipo_de_habitacion_id;
    }
    
    
    
}
