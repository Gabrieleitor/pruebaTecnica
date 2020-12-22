package com.appgate.pruebaTecnica.calculo.domain;

public final  class CrearInteger {

    public static Integer crear(Double value) {
        try {
            return value.intValue();
        }catch (Exception e){
            throw new IllegalArgumentException("No se puede convertir en entero");
        }

    }
}
