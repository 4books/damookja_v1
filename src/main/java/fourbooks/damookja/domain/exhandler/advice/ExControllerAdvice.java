package fourbooks.damookja.domain.exhandler.advice;


import fourbooks.damookja.domain.exhandler.ErrorResult;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice("fourbooks.damookja.domain.controller")
public class ExControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResult> handleEntityNotFoundException(EntityNotFoundException ex) {
        log.error("[EntityNotFoundException] {}", ex.getMessage());
        ErrorResult errorResult = new ErrorResult("Not Found", ex.getMessage());
        return new ResponseEntity<>(errorResult, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResult> handleException(Exception ex) {
        log.error("[Exception] {}", ex.getMessage());
        ErrorResult errorResult = new ErrorResult("Exception", ex.getMessage());
        return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
