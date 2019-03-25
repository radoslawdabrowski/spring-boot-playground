package com.coig.intraid.account.controllers;

import com.coig.intraid.account.dto.ProfileDto;
import com.coig.intraid.account.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final ProfileService profileService;

    @Autowired
    public AccountController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @GetMapping(path = "/profile", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileDto> get() {
        return new ResponseEntity<>(profileService.get(), HttpStatus.OK);
    }

}
