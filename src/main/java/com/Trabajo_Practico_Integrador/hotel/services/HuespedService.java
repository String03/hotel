/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Trabajo_Practico_Integrador.hotel.services;

import com.Trabajo_Practico_Integrador.hotel.entities.Huespedes;
import com.Trabajo_Practico_Integrador.hotel.repositories.huespedesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fvg
 */
@Service
public class HuespedService {
    @Autowired
    private huespedesRepository huespedRepository;
    
    public List<Huespedes> ListarHuespedes(){
        return huespedRepository.findAll();
    }
    
    public void EliminarHuespedes(Huespedes huesped){
        huespedRepository.delete(huesped);
    }
    
    public void AgregarHuespedes(Huespedes huesped){
        huespedRepository.save(huesped);
    }
    
}
