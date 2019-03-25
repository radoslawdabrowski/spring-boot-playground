package com.coig.intraid.account.services.impl;

import com.coig.intraid.account.dto.ProfileDto;
import com.coig.intraid.account.entities.TokenEntity;
import com.coig.intraid.account.entities.UserEntity;
import com.coig.intraid.account.repositories.TokenRepository;
import com.coig.intraid.account.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final TokenRepository tokenRepository;

    private final HttpServletRequest request;

    @Autowired
    public ProfileServiceImpl(HttpServletRequest request, TokenRepository tokenRepository) {
        this.request = request;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public ProfileDto get() {
        TokenEntity entity = tokenRepository.findByValue(request.getHeader("X-Auth-Token"));
        if(entity != null) {
            UserEntity user = entity.getUser();
            ProfileDto dto = new ProfileDto();
            dto.setFirstName(user.getFirstName());
            dto.setLastName(user.getLastName());
            dto.setLogin(user.getLogin());
            return dto;
        }
        return null;
    }

}
