package com.br.digitalMarketPlace.modules.clients.domain.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionEnum {
    CUSTOMER_NOT_FOUND(HttpStatus.NOT_FOUND, "Customer not Found");

    private final HttpStatus status;
    private final String message;

    ExceptionEnum(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
