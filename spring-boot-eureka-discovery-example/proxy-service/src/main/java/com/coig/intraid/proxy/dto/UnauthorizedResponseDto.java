package com.coig.intraid.proxy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UnauthorizedResponseDto {

    private boolean success;
    private String message;

}
