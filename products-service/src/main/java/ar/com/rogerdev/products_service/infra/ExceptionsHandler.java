package ar.com.rogerdev.products_service.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404 (EntityNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400 (MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors().stream().map(exceptionResDTO::new);
        return ResponseEntity.badRequest().body(errors);
    }

    private record exceptionResDTO (String field, String message) {
        public exceptionResDTO (FieldError error) {
            this( error.getField(), error.getDefaultMessage());
        }
    }

}
