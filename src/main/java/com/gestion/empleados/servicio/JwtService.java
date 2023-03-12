package com.gestion.empleados.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gestion.empleados.modelo.JwtRequest;
import com.gestion.empleados.modelo.JwtResponse;
import com.gestion.empleados.modelo.Persona;
import com.gestion.empleados.repositorio.PersonaRepositorio;
import com.gestion.empleados.repositorio.UserRepositorio;
import com.gestion.empleados.util.JwtUtil;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private PersonaRepositorio repositorio;
	
	
	@Autowired
	private UserRepositorio userrepositorio;
	
	@Autowired(required=true)

    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);
        Persona user = repositorio.findByUsername(userName);
      //  UserDetails userDetails = loadUserByUsername(userName);
        String newGeneratedToken = jwtUtil.generateToken(user);

		return new JwtResponse(user, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Persona persona = repositorio.findByUsername(username);
    //	Persona persona = userrepositorio.findById(username);
    	
		if (persona != null) {
			return new org.springframework.security.core.userdetails.User(persona.getUsername(), persona.getPassword(),
					getAuthority(persona));
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
    }

    private Set<SimpleGrantedAuthority> getAuthority(Persona user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getTipousuario()));
		return authorities;
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}