package com.jjk.springboot.dcb.error;

public class DepartmentNotFound extends RuntimeException {
    public DepartmentNotFound() {
        super("Deparment Not Found: !!!" );
    }

    public DepartmentNotFound(String message) {
        super(message);
    }
}
