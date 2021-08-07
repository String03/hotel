/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;


import Logica.tipo_de_habitaciones;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fvg
 */
public interface tipo_de_habitacionesRepository extends JpaRepository<tipo_de_habitaciones,Integer>{
    
}
