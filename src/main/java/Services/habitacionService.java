/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Logica.habitaciones;
import Repositories.habitacionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fvg
 */
@Service
public class habitacionService {
    @Autowired
    private habitacionesRepository habitacionRepository;
    
    public List<habitaciones> ListarHabitaciones(){
        return habitacionRepository.findAll();
    }
    
    
    public void AgregarHabitaciones(habitaciones habitacion){
        habitacionRepository.save(habitacion);
    }
    
    public void EliminarHabitaciones(habitaciones habitacion){
        habitacionRepository.delete(habitacion);
    }
    
   
    
    
}
