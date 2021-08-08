/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Trabajo_Practico_Integrador.hotel.services;


import com.Trabajo_Practico_Integrador.hotel.entities.Tipo_de_habitaciones;
import com.Trabajo_Practico_Integrador.hotel.repositories.tipo_de_habitacionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fvg
 */
@Service
public class Tipo_de_habitacionService {
    @Autowired
    private tipo_de_habitacionesRepository tipo_de_habitacionRepository;
    
    public List<Tipo_de_habitaciones> ListarHuespedes(){
        return tipo_de_habitacionRepository.findAll();
    }
    
    public void EliminarHuespedes(Tipo_de_habitaciones tipo_de_habitacion){
        tipo_de_habitacionRepository.delete(tipo_de_habitacion);
    }
    
    public void AgregarHuespedes(Tipo_de_habitaciones tipo_de_habitacion){
        tipo_de_habitacionRepository.save(tipo_de_habitacion);
    }
}
