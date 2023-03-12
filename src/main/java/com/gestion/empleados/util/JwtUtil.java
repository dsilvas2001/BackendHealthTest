package com.gestion.empleados.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.gestion.empleados.modelo.Persona;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Component
public class JwtUtil {
	
	private static final String SECRET_KEY = "learn_programming_yourself";

    private static final int TOKEN_VALIDITY = 3600 * 5;

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public String generateToken(Persona user) {
    	
    	 Date now = new Date();
         Date expiration = new Date(now.getTime() + 3600000);
         String tip = user.getTipousuario();
         
         String usuariotoken = user.getUsername();
         Claims claims = Jwts.claims().setSubject(usuariotoken);
         
         claims.put("TipoUsuario", user.getTipousuario()); 
         return Jwts.builder()
                 .setClaims(claims)
                 .setIssuedAt(now)
                 .setExpiration(expiration)
                 .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                 .compact();
    }
    
 

}
