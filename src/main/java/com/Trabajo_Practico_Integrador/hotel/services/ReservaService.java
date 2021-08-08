/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Trabajo_Practico_Integrador.hotel.services;

import com.Trabajo_Practico_Integrador.hotel.entities.Huespedes;
import com.Trabajo_Practico_Integrador.hotel.entities.Reservas;
import com.Trabajo_Practico_Integrador.hotel.repositories.reservasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fvg
 */
@Service
public class ReservaService {
    @Autowired
    private reservasRepository reservasRepository;
    
    public List<Reservas> ListarHuespedes(){
        return reservasRepository.findAll();
    }
    
    public void EliminarHuespedes(Reservas reserva){
        reservasRepository.delete(reserva);
    }
    
    public void AgregarHuespedes(Reservas reserva){
        reservasRepository.save(reserva);
    }
    
}
