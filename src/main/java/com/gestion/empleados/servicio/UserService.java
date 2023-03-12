package com.gestion.empleados.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestion.empleados.modelo.Persona;
import com.gestion.empleados.repositorio.PersonaRepositorio;

import java.util.HashSet;
import java.util.Set;

@Service

public class UserService {

	@Autowired
	private PersonaRepositorio userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	   @Autowired
	    private PersonaRepositorio repositorio;

	
	public Persona registerNewUser(Persona user) {
		user.setPassword(getEncodedPassword(user.getPassword()));
		return userDao.save(user);
	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
	
	
	public void initRoleAndUser() {

		Persona adminRole = new Persona();
        adminRole.setTipousuario("Administrador");

        Persona userRole = new Persona();
        userRole.setTipousuario("Paciente");
        repositorio.save(userRole);

        Persona adminUser = new Persona();
        adminUser.setUsername("admin123");
        adminUser.setPassword(getEncodedPassword("123"));
        adminUser.setName("admin");
        adminUser.setEmail("donaldsilva@gmail.com");
        Set<Persona> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        repositorio.save(adminUser);

//        User user = new User();
//        user.setUserName("raj123");
//        user.setUserPassword(getEncodedPassword("raj@123"));
//        user.setUserFirstName("raj");
//        user.setUserLastName("sharma");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userDao.save(user);
    }
}
