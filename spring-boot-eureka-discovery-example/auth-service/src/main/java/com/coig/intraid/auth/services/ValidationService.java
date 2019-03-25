package com.coig.intraid.auth.services;

import com.coig.intraid.auth.dto.JwtTokenValidationDto;

public interface ValidationService {

    boolean validate(JwtTokenValidationDto dto);

}
