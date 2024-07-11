package kz.itstep.rest2.handler;

import kz.itstep.rest2.exceptions.messages.CustomExceptionMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(
                new CustomExceptionMessage(LocalDateTime.now(),
                        ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
                        400 ));
    }
}
