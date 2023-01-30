package kg.info.tv.services;

import io.jsonwebtoken.*;
import kg.info.tv.exeptions.TVException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Objects;

@Service
public class TokensServiceImpl implements TokensService {

    @Value("${jwtSecret}")
    private String secretKey;

    @Value("${jwtLogin}")
    private String myLogin;

    @Value("${jwtPassword}")
    private String myPassword;

    @Override
    public ResponseEntity<?> configCode(String login, String code) throws TVException {

        if (!Objects.equals(login, myLogin) || !Objects.equals(code, myPassword)) {
            throw new TVException("Incorrect login or password");
        }
        Calendar tokenTimeLive = Calendar.getInstance();
        tokenTimeLive.add(Calendar.HOUR, 3);

        String token = Jwts.builder()
                        .claim("login", login)
                        .setExpiration(tokenTimeLive.getTime())
                        .signWith(SignatureAlgorithm.HS256, secretKey)
                        .compact();
        return ResponseEntity.ok(token);
    }

    public ResponseEntity<?> verifyLogin(String token) {
        try {
            Jws<Claims> jwt = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return ResponseEntity.ok(jwt.getBody().get("login"));

        } catch (ExpiredJwtException jwtException) {
            return new ResponseEntity<>("Время действия токена истек", HttpStatus.CONFLICT);

        } catch (UnsupportedJwtException jwtException) {
            return new ResponseEntity<>("Неподерживаемый токен", HttpStatus.CONFLICT);

        } catch (MalformedJwtException jwtException) {
            return new ResponseEntity<>("Некорректный токен", HttpStatus.CONFLICT);

        } catch (SignatureException signatureException) {
            return new ResponseEntity<>("Некорректная подпись в токене!", HttpStatus.CONFLICT);

        } catch (Exception exception) {
            return new ResponseEntity<>("unauthorized", HttpStatus.CONFLICT);
        }
    }
}
