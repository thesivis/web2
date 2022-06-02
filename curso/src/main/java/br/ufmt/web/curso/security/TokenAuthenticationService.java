package br.ufmt.web.curso.security;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenAuthenticationService {

  private static long EXPIRATION_TIME;
  private static String SECRET;
  private static final String TOKEN_PREFIX = "Bearer";
  private static final String HEADER_STRING = "Authorization";

  @Value("${curso.app.jwtSecret}")
  private void setSECRET(String secret) {
    SECRET = secret;
  }

  @Value("${curso.app.jwtExpirationMs}")
  private void setEXPIRATION_TIME(long expiration) {
    EXPIRATION_TIME = expiration;
  }

  public static String gerarJWTToken(String username) {
    return Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(SignatureAlgorithm.HS512, SECRET).compact();
  }
//dontfile.com/web2-ufmt
  static Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader(HEADER_STRING);

    if (token != null) {
      // faz parse do token
      String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
          .getSubject();

      if (user != null) {
        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
      }
    }
    return null;
  }

}