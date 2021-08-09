/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Trabajo_Practico_Integrador.hotel.endpoints;

import com.Trabajo_Practico_Integrador.hotel.entities.Habitaciones;
import com.Trabajo_Practico_Integrador.hotel.services.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fvg
 */
@RestController
@RequestMapping(path = "/api/habitaciones")
public class habitacionendpoints {
    @Autowired
    private HabitacionService service;
    
   
    @GetMapping
    public ResponseEntity listarhabitacion(){
        return ResponseEntity.ok().body(service.ListarHabitaciones());
    }
    
    @PostMapping(consumes = "application/json")
    public ResponseEntity agregarhabitacion(@RequestBody Habitaciones habitacion){
        try{
            service.AgregarHabitaciones(habitacion);
            return ResponseEntity.ok().build();
        }
        catch(Exception ex){
            return ResponseEntity.badRequest().body(ex);
        }
    }
}
