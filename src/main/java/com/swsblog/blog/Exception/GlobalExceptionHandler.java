package com.swsblog.blog.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> methodArgumentNotValidHandler(MethodArgumentNotValidException e) {
        String msg = e.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage();
        return ResponseEntity.badRequest().body(msg);
    }

//    @ExceptionHandler
//    public ResponseEntity<String> logHandler(UsernameNotFoundException e) {
//        System.out.println(e.getMessage());
//        return ResponseEntity.badRequest().body(e.getMessage());
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<String> pasHandler(BadCredentialsException e) {
//        System.out.println(e.getMessage());
//        return ResponseEntity.badRequest().body(e.getMessage());
//    }

    @ExceptionHandler
    public ResponseEntity<String> illegalArgumentHandler(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}