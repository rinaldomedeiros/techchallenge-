package br.com.fiap.soat8.grp14.techchallenge.adapters.in.web.util;


import br.com.fiap.soat8.grp14.techchallenge.domain.exceptions.EmptyItensException;
import br.com.fiap.soat8.grp14.techchallenge.domain.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ResourceExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardValidationError> erroValidacao(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest) {

        List<ValidationError> validationErrors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ValidationError(error.getField(), error.getDefaultMessage()))
                .toList();

        StandardValidationError standardError = StandardValidationError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Erro de validação")
                .timestamp(LocalDateTime.now())
                .errorList(validationErrors)
                .build();

        return ResponseEntity.status(standardError.getStatus()).body(standardError);
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> erroValidacao(EntityNotFoundException e, HttpServletRequest httpServletRequest) {


        StandardError standardError = StandardError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(standardError.getStatus()).body(standardError);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyItensException.class)
    public ResponseEntity<StandardError> erroValidacao(EmptyItensException e, HttpServletRequest httpServletRequest) {

        StandardError standardError = StandardError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(standardError.getStatus()).body(standardError);
    }

}
