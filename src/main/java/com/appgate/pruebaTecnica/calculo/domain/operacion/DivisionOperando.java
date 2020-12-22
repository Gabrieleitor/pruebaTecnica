package com.appgate.pruebaTecnica.calculo.domain.operacion;

import com.appgate.pruebaTecnica.calculo.domain.Calculo;

import java.math.BigDecimal;

public class DivisionOperando implements Operando {

    @Override
    public Calculo calcular(Calculo calculo) {
        BigDecimal resultado = new BigDecimal(calculo.getOperandos().get(0));
        for (int i = 1; i < calculo.getOperandos().size(); i++) {
            if (0 == calculo.getOperandos().get(i)) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            } else {
                resultado = resultado.divide(new BigDecimal(calculo.getOperandos().get(i)));
            }
        }
        calculo.setResultado(resultado);
        calculo.setOperacion(OperacionEnum.DIVISION.name());
        return calculo;
    }
}
