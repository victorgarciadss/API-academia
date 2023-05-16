package me.dio.academia.digital.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValid
        (MethodArgumentNotValidException e, HttpServletRequest request){
            StandardError err = new StandardError();
            err.setTimestamp(Instant.now());
            err.setStatus(HttpStatus.BAD_REQUEST.value());
            err.setError("Missing arguments in request");
            err.setMessage(e.getMessage());
            err.setPath(request.getRequestURI());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
        }
}
