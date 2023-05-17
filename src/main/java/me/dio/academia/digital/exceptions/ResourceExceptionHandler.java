package me.dio.academia.digital.exceptions;

import java.time.Instant;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandardError> noSuchElement(
        NoSuchElementException e, HttpServletRequest request
    ){
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Id not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> MessageNotReadable(
        HttpMessageNotReadableException e, HttpServletRequest request
    ){
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Required request body is missing");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
