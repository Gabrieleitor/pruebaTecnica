package com.appgate.pruebaTecnica.calculo.application;

import com.appgate.pruebaTecnica.calculo.domain.operacion.OperacionEnum;
import org.springframework.stereotype.Service;

@Service
public final class CrearOperador {

    public OperacionEnum crear(String value) {
        for (OperacionEnum operando : OperacionEnum.values()) {
            if (operando.name().equals(value.toUpperCase())) {
                return operando;
            }
        }
        throw new IllegalArgumentException("No se reconose el operador");
    }
}
