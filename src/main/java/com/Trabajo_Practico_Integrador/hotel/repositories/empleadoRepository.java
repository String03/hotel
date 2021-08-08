/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Trabajo_Practico_Integrador.hotel.repositories;

import com.Trabajo_Practico_Integrador.hotel.entities.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fvg
 */
public interface empleadoRepository extends JpaRepository<Empleados,Integer>{
    
}
