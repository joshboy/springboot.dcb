package com.jjk.springboot.dcb.error;

import com.jjk.springboot.dcb.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFound.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFound ex) {
        ErrorMessage errorMessage= new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
