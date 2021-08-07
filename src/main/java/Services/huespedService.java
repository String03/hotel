/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Logica.huespedes;
import Repositories.huespedesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fvg
 */
@Service
public class huespedService {
    @Autowired
    private huespedesRepository huespedRepository;
    
    public List<huespedes> ListarHuespedes(){
        return huespedRepository.findAll();
    }
    
    public void EliminarHuespedes(huespedes huesped){
        huespedRepository.delete(huesped);
    }
    
    public void AgregarHuespedes(huespedes huesped){
        huespedRepository.save(huesped);
    }
    
}
