package com.coig.intraid.auth.contollers;

import com.coig.intraid.auth.dto.JwtTokenDto;
import com.coig.intraid.auth.dto.LoginDto;
import com.coig.intraid.auth.dto.RegisterDto;
import com.coig.intraid.auth.entities.UserEntity;
import com.coig.intraid.auth.handlers.OperationFailedException;
import com.coig.intraid.auth.services.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public class AuthController {

    private final AuthenticateService authenticateService;

    @Autowired
    public AuthController(AuthenticateService authenticateService) {
        this.authenticateService = authenticateService;
    }

    @PostMapping(value = "/sign-in", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JwtTokenDto> login(@RequestBody LoginDto dto) throws OperationFailedException {
        return new ResponseEntity<>(authenticateService.login(dto), HttpStatus.OK);
    }

    @PostMapping(value = "/sign-up", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> register(@RequestBody RegisterDto dto) throws OperationFailedException {
        return new ResponseEntity<>(authenticateService.register(dto), HttpStatus.OK);
    }

    @GetMapping(value = "/sign-out", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> logout() {
        return new ResponseEntity<>(authenticateService.logout(), HttpStatus.OK);
    }

}
