package kg.info.tv.services;

import kg.info.tv.exeptions.TVException;
import org.springframework.http.ResponseEntity;

public interface TokensService {

    ResponseEntity<?> configCode(String login, String code) throws TVException;

    ResponseEntity<?> verifyLogin(String token);
}
