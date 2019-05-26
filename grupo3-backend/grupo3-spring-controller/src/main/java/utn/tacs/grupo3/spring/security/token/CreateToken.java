package utn.tacs.grupo3.spring.security.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

public class CreateToken {

    // Método para crear el JWT y enviarlo al cliente en el header de la respuesta
    public void addAuthentication(HttpServletResponse res, Authentication authentication) {

        final String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        String token = Jwts.builder()
                .setSubject(authentication.getName())
                .claim("ROL", authorities)
                // Hash con el que firmaremos la clave
                .signWith(SignatureAlgorithm.HS512, "P@tit0")
                .compact();

        //agregamos al encabezado el token
        res.addHeader("Authorization", "Bearer " + token);
    }
}
