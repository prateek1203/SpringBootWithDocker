package com.java.app.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@NoArgsConstructor
public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String exception) {
        super(exception);
    }
}
