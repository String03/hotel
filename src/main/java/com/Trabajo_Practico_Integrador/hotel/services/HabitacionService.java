/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Trabajo_Practico_Integrador.hotel.services;

import com.Trabajo_Practico_Integrador.hotel.entities.Habitaciones;
import com.Trabajo_Practico_Integrador.hotel.repositories.habitacionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fvg
 */
@Service
public class HabitacionService {
    @Autowired
    private habitacionesRepository habitacionRepository;
    
    public List<Habitaciones> ListarHabitaciones(){
        return habitacionRepository.findAll();
    }
    
    
    public void AgregarHabitaciones(Habitaciones habitacion){
        habitacionRepository.save(habitacion);
    }
    
    public void EliminarHabitaciones(Habitaciones habitacion){
        habitacionRepository.delete(habitacion);
    }
    
   
    
    
}
