package com.intraway.mefa.fizzbuzz.infraestructura.error;

import com.intraway.mefa.fizzbuzz.dominio.exepcion.ErrorRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler
{
    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex,final WebRequest request) {
        final ErrorRequest errorRequest =new ErrorRequest(request.getDescription(false));
        return new ResponseEntity<Object>(errorRequest.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }


}
