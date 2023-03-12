package com.gestion.empleados.modelo;

public class JwtResponse {
	

    private Persona user;
    private String jwtToken;

    public JwtResponse(Persona user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

	public Persona getUser() {
		return user;
	}

	public void setUser(Persona user) {
		this.user = user;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

   
	
	
}
