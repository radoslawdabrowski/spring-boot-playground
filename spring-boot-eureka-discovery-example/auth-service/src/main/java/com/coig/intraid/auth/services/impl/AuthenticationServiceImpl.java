package com.coig.intraid.auth.services.impl;

import com.coig.intraid.auth.dto.JwtTokenDto;
import com.coig.intraid.auth.dto.LoginDto;
import com.coig.intraid.auth.dto.RegisterDto;
import com.coig.intraid.auth.entities.JwtTokenEntity;
import com.coig.intraid.auth.entities.UserEntity;
import com.coig.intraid.auth.handlers.OperationFailedException;
import com.coig.intraid.auth.repositories.JwtTokenRepository;
import com.coig.intraid.auth.repositories.UserRepository;
import com.coig.intraid.auth.services.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AuthenticationServiceImpl implements AuthenticateService {

    private final JwtTokenRepository jwtTokenRepository;

    private final UserRepository userRepository;

    private final HttpServletRequest request;

    @Autowired
    public AuthenticationServiceImpl(JwtTokenRepository jwtTokenRepository, UserRepository userRepository, HttpServletRequest request) {
        this.jwtTokenRepository = jwtTokenRepository;
        this.userRepository = userRepository;
        this.request = request;
    }

    @Override
    public JwtTokenDto login(LoginDto dto) throws OperationFailedException {

        UserEntity userEntity = userRepository.findByLogin(dto.getLogin());
        if(userEntity != null && userEntity.checkPassword(dto.getPassword())) {
            JwtTokenEntity entity = new JwtTokenEntity().build(userEntity);
            entity = jwtTokenRepository.save(entity);
            if(entity != null) {
                return new JwtTokenDto(entity.getValue());
            }

        }
        throw new OperationFailedException("Login or password are incorrect");
    }

    @Override
    public Boolean logout() {
        String string = request.getHeader("X-Auth-Token");
        try {
            jwtTokenRepository.deleteByValue(string);
        } catch (IllegalArgumentException ignore) {
        }
        return true;
    }

    @Override
    public UserEntity register(RegisterDto dto) throws OperationFailedException {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(dto.getFirstName());
        userEntity.setLastName(dto.getLastName());
        userEntity.setLogin(dto.getLogin());
        userEntity.setPassword(dto.getPassword());
        userEntity =  userRepository.save(userEntity);
        if(userEntity != null) {
            return userEntity;
        }
        throw new OperationFailedException("Something goes wrong!");
    }

}
