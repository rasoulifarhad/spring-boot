package com.farhad.example.springdatajpa.onetomany;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// When an LibraryNotFoundException is thrown, this extra tidbit of Spring MVC configuration is used to render an HTTP 404:
@ControllerAdvice
public class LibraryNotFoundAdvice {
    // @ResponseBody signals that this advice is rendered straight into the response body.
    // @ExceptionHandler configures the advice to only respond if an LibraryNotFoundException is thrown.
    // @ResponseStatus says to issue an HttpStatus.NOT_FOUND, i.e. an HTTP 404.
    // The body of the advice generates the content. In this case, it gives the message of the exception.
    @ResponseBody
    @ExceptionHandler(LibraryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String libraryNotFoundHandler(LibraryNotFoundException e) {
        return e.getMessage();
    } 
}
