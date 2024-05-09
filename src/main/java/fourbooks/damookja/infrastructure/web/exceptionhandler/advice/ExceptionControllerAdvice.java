package fourbooks.damookja.infrastructure.web.exceptionhandler.advice;


import fourbooks.damookja.infrastructure.web.exceptionhandler.ErrorResult;
import fourbooks.damookja.domain.exception.RecipeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice("fourbooks.damookja.application.port.in.web.controller")
public class ExceptionControllerAdvice {

    @ExceptionHandler(RecipeNotFoundException.class)
    public ResponseEntity<ErrorResult> handleItemNotFoundException(RecipeNotFoundException ex) {
        log.error("[ItemNotFoundException] {}", ex.getMessage());
        ErrorResult errorResult = new ErrorResult("Not Found", ex.getMessage());
        return new ResponseEntity<>(errorResult, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResult> handleException(Exception ex) {
        log.error("[Exception] {}", ex.getMessage());
        ErrorResult errorResult = new ErrorResult("Exception", ex.getMessage());
        return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
