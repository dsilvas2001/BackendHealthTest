package com.gestion.empleados.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.empleados.modelo.Persona;
import com.gestion.empleados.repositorio.PersonaRepositorio;


import org.springframework.security.crypto.password.PasswordEncoder;



@Service
public class PersonaServicio {
	 @Autowired(required=true)

	private PersonaRepositorio personaRepositorio;

	// public List<Persona> listAll(String palabraClave){
	// if(palabraClave!= null) {
	// return personaRepositorio.findByUsernameStartingWith(palabraClave);
	// }
	// return personaRepositorio.findAll();
	// }

	public void save(Persona persona) {
		personaRepositorio.save(persona);
	}

	public Persona get(Long id) {
		return personaRepositorio.findById(id).get();
	}

	@Autowired
	private PersonaRepositorio repositoriopersona;

	// public void initRolesAndUser() {

	// Persona adminUser = new Persona();
	// adminUser.setName("admin123");
	// adminUser.setUsername("admin");
	// adminUser.setEmail("dsilvas@uteq.edu.ec");
	// adminUser.setTipousuario("Administrador");
	// repositoriopersona.save(adminUser);

	// }
	
}
