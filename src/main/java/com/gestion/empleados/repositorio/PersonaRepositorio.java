package com.gestion.empleados.repositorio;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gestion.empleados.modelo.Persona;


@Repository
@Service
public interface PersonaRepositorio extends JpaRepository<Persona, Long>{


	Persona findByUsername(String username);
	
	public List<Persona> findAll();

	
	List<Persona> findByTipousuario(String tipousuario);

	//Persona findByTipousuario(String tipousuario);
	
	//Optional<Persona> findByTipousuario(String tipousuario);
	
	//Eliminar 
	 //List<Persona> findByUsernameStartingWith(String palabraClave);
	//@Query("SELECT o FROM personas o WHERE tipousuario like '%:tipousuario%'")
	//@Query("SELECT u FROM healthtest.personas u WHERE u.tipousuario = 'Paciente'")
	//List<Persona> findAllPacientes();

	//@Query("SELECT o FROM Object o WHERE (:name is null or o.name like %:name%) and (:description is null or o.description like %:description%)")
    //List<Persona> searchObjects(@Param("tipousuario") String name);

}


