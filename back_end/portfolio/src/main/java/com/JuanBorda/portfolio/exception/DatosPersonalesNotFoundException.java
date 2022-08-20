package com.JuanBorda.portfolio.exception;

public class DatosPersonalesNotFoundException extends RuntimeException {
    
    public DatosPersonalesNotFoundException(String mensaje){
        super(mensaje);
    }
}
