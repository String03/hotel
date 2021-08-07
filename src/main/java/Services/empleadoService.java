/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Logica.empleados;
import Repositories.empleadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fvg
 */
@Service

public class empleadoService {
    @Autowired
    private empleadoRepository empleadosRepository;

    public List<empleados> ListarEmpleado(){
        return empleadosRepository.findAll();
    }

    public void AgregarEmpleado(empleados empleado){
        empleadosRepository.save(empleado);
    }
    
    
    public void EliminarEmpleado(empleados empleado){
        empleadosRepository.delete(empleado);
    }
    
    public void ModificarEmpleado(empleados empleado){
        empleadosRepository.delete(empleado);
    }
    
}
