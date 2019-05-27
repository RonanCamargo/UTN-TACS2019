package utn.tacs.grupo3.spring.security.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class CreateToken {

    // Método para crear el JWT y enviarlo al cliente en el header de la respuesta
    public void addAuthentication(HttpServletResponse res, Authentication authentication) {

        final String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        String token = createToken(authentication, authorities);

        //agregar al encabezado el token
        addTheTokenToTheHeader(res, token);

        sendTokenAsJson(res,token);
    }

    private void addTheTokenToTheHeader(HttpServletResponse res, String token) {
        res.addHeader("Authorization", "Bearer " + token);
    }

    private String createToken(Authentication authentication, String authorities) {
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("ROL", authorities)
                // Hash con el que firmaremos la clave
                .signWith(SignatureAlgorithm.HS512, "P@tit0")
                .compact();
    }

    private void sendTokenAsJson(HttpServletResponse res, String token) {
        res.setContentType("application/json");
        try {
            res.getOutputStream().print("{\"token\":\""+token+"\"}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
