package com.Trabajo_Practico_Integrador.hotel;


import com.Trabajo_Practico_Integrador.hotel.entities.Habitaciones;
import com.Trabajo_Practico_Integrador.hotel.services.HabitacionService;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fvg
 */
@SpringBootTest
//@RunWith(SpringRunner.class)
public class ServiceTest {
      @Autowired
        private HabitacionService habitacionesServices;
	@Test
	void contextLoads() {
            List<Habitaciones> habitacion = habitacionesServices.ListarHabitaciones();
            //Assert.noNullElements(habitacion);
        }
}
