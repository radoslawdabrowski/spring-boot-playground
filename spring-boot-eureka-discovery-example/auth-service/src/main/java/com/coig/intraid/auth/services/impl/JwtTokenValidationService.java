package com.coig.intraid.auth.services.impl;

import com.coig.intraid.auth.dto.JwtTokenValidationDto;
import com.coig.intraid.auth.entities.JwtTokenEntity;
import com.coig.intraid.auth.repositories.JwtTokenRepository;
import com.coig.intraid.auth.services.ValidationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtTokenValidationService implements ValidationService {

    private final JwtTokenRepository jwtTokenRepository;

    private List<String> permit = new ArrayList<String>() {
        {
            add("auth");
        }
    };

    @Autowired
    public JwtTokenValidationService(JwtTokenRepository jwtTokenRepository) {
        this.jwtTokenRepository = jwtTokenRepository;
    }

    @Override
    public boolean validate(JwtTokenValidationDto dto) {

        if(!checkIfAuthorizationNotRequired(dto.getPath())) {
            if(StringUtils.isEmpty(dto.getToken())) {
                return false;
            } else {
                JwtTokenEntity tokenEntity = jwtTokenRepository.findByValue(dto.getToken());
                return tokenEntity != null;
            }
        } else {
            return true;
        }
    }

    private boolean checkIfAuthorizationNotRequired(String path){
        for (String s : permit){
            if (path.contains(s))
                return true;
        }
        return false;
    }
}
