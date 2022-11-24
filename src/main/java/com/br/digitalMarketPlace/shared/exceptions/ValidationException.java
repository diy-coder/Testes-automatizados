package com.br.digitalMarketPlace.shared.exceptions;

import com.br.digitalMarketPlace.modules.clients.domain.enums.ExceptionEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ValidationException extends RuntimeException {

    private final HttpStatus status;

    public ValidationException(ExceptionEnum ex) {
        super(ex.getMessage());
        this.status = ex.getStatus();
    }
}
