/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Logica.huespedes;
import Logica.reservas;
import Repositories.reservasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fvg
 */
@Service
public class reservaService {
    @Autowired
    private reservasRepository reservasRepository;
    
    public List<reservas> ListarHuespedes(){
        return reservasRepository.findAll();
    }
    
    public void EliminarHuespedes(reservas reserva){
        reservasRepository.delete(reserva);
    }
    
    public void AgregarHuespedes(reservas reserva){
        reservasRepository.save(reserva);
    }
    
}
