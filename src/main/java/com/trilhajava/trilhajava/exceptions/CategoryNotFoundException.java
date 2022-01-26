package com.trilhajava.trilhajava.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@AllArgsConstructor
//@NoArgsConstructor
@Data
@Getter
@Setter
public class CategoryNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CategoryNotFoundException(String message) {
        super(message);
    }


}
