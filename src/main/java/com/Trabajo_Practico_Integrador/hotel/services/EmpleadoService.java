/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Trabajo_Practico_Integrador.hotel.services;

import com.Trabajo_Practico_Integrador.hotel.entities.Empleados;
import com.Trabajo_Practico_Integrador.hotel.repositories.empleadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fvg
 */
@Service

public class EmpleadoService {
    @Autowired
    private empleadoRepository empleadosRepository;

    public List<Empleados> ListarEmpleado(){
        return empleadosRepository.findAll();
    }

    public void AgregarEmpleado(Empleados empleado){
        empleadosRepository.save(empleado);
    }
    
    
    public void EliminarEmpleado(Empleados empleado){
        empleadosRepository.delete(empleado);
    }
    
   
    
    
}
