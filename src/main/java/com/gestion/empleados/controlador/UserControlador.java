package com.gestion.empleados.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.servicio.UserService;

import javax.annotation.PostConstruct;


@Controller 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v2/")

public class UserControlador {
	
	


}
