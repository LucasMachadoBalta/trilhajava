package com.trilhajava.trilhajava.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;
}
