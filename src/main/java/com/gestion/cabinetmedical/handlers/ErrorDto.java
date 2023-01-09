package com.gestion.cabinetmedical.handlers;

import com.gestion.cabinetmedical.exceptions.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ErrorDto {
    private String message;
    private ErrorCodes errorCodes;
    private List<String> errors;
    private Integer httpCode;
}
