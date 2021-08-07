/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Logica.tipo_de_habitaciones;
import Repositories.tipo_de_habitacionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fvg
 */
@Service
public class tipo_de_habitacionService {
    @Autowired
    private tipo_de_habitacionesRepository tipo_de_habitacionRepository;
    
    public List<tipo_de_habitaciones> ListarHuespedes(){
        return tipo_de_habitacionRepository.findAll();
    }
    
    public void EliminarHuespedes(tipo_de_habitaciones tipo_de_habitacion){
        tipo_de_habitacionRepository.delete(tipo_de_habitacion);
    }
    
    public void AgregarHuespedes(tipo_de_habitaciones tipo_de_habitacion){
        tipo_de_habitacionRepository.save(tipo_de_habitacion);
    }
}
