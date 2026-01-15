package com.marcos.open_jobs.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    private String ErrorMessage;
    private String field;
}
