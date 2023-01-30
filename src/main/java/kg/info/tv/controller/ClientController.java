package kg.info.tv.controller;

import kg.info.tv.models.dto.ResponseClientDTO;
import kg.info.tv.services.ClientService;
import kg.info.tv.services.TokensService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/client")
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private TokensService tokensService;
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<?> getVersion(@RequestHeader("token") String token,
                                        @RequestParam("mac") String ipAddress) {
        ResponseEntity<?> responseEntity = tokensService.verifyLogin(token);
        if(!responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            return responseEntity;
        }
        ResponseClientDTO response = clientService.getVersion(ipAddress);
        return ResponseEntity.ok(response);
    }
}
