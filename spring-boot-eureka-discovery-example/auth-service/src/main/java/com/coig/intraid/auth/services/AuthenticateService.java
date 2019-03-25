package com.coig.intraid.auth.services;

import com.coig.intraid.auth.dto.JwtTokenDto;
import com.coig.intraid.auth.dto.LoginDto;
import com.coig.intraid.auth.dto.RegisterDto;
import com.coig.intraid.auth.entities.UserEntity;
import com.coig.intraid.auth.handlers.OperationFailedException;

public interface AuthenticateService {

    JwtTokenDto login(LoginDto dto) throws OperationFailedException;

    Boolean logout();

    UserEntity register(RegisterDto dto) throws OperationFailedException;

}
