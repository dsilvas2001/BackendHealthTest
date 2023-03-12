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

import org.springframework.data.repository.CrudRepository;



@Repository
@Service


public interface UserRepositorio extends CrudRepository<Persona, String>{

}
