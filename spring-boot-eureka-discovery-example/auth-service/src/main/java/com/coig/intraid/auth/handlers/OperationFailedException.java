package com.coig.intraid.auth.handlers;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class OperationFailedException extends Exception{

    private Boolean status;

    public OperationFailedException(String message) {
        super(message);
        status = false;
    }

}
