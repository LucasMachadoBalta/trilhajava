package com.trilhajava.trilhajava.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@AllArgsConstructor
//@NoArgsConstructor
@Data
@Getter
@Setter
public class EntryNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntryNotFoundException(String message) {
        super(message);
    }

}
