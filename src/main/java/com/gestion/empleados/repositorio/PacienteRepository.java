package com.gestion.empleados.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.modelo.Persona;

@Repository

public interface PacienteRepository extends JpaRepository<Persona, Long>{
	
	Persona findByUsername(String username);

	
	//Persona findByTipousuario(String tipousuario);
	
	//List<Persona> findByTipousuario(String tipousuario);

}
