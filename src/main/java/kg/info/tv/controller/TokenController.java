package kg.info.tv.controller;

import kg.info.tv.exeptions.TVException;
import kg.info.tv.services.TokensService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/get_token")
@RestController
@Slf4j
public class TokenController {
    private TokensService tokensService;
    public TokenController(TokensService tokensService) {
        this.tokensService = tokensService;
    }

    @GetMapping
    public ResponseEntity<?> configCode(@RequestParam String login, @RequestParam String code){
        try {
            return tokensService.configCode(login, code);
        } catch (TVException e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }
}
