/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;


import Logica.habitaciones;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fvg
 */
public interface habitacionesRepository extends JpaRepository<habitaciones,Integer>{
    
}
