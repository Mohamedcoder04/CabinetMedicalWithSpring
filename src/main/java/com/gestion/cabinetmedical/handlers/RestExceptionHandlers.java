package com.gestion.cabinetmedical.handlers;

import com.gestion.cabinetmedical.exceptions.EntityNotFoundException;
import com.gestion.cabinetmedical.exceptions.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handlerEntityNotFoudException(EntityNotFoundException exception, WebRequest request){
        final HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        final ErrorDto errorDto = ErrorDto.builder()
                .message(exception.getMessage())
                .httpCode(httpStatus.value())
                .errorCodes(exception.getErrorCodes())
                .build();
        return new ResponseEntity<>(errorDto, httpStatus);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handlerInvalidEntityException(InvalidEntityException exception , WebRequest request){
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        final ErrorDto errorDto = ErrorDto.builder()
                .errorCodes(exception.getErrorCodes())
                .message(exception.getMessage())
                .httpCode(httpStatus.value())
                .build();

        return new ResponseEntity<>(errorDto, httpStatus);
    }
}
