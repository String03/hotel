/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Trabajo_Practico_Integrador.hotel.endpoints;

import com.Trabajo_Practico_Integrador.hotel.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fvg
 */
@RestController
@RequestMapping(path = "/empleados")
public class clienteendpoints {
    @Autowired
    private EmpleadoService service;
    
   
    @GetMapping
    public ResponseEntity listarempleado(){
        return ResponseEntity.ok().body(service.ListarEmpleado());
    }
    
}
