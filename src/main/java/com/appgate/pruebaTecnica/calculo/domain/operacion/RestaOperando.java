package com.appgate.pruebaTecnica.calculo.domain.operacion;

import com.appgate.pruebaTecnica.calculo.domain.Calculo;

import java.math.BigDecimal;

public class RestaOperando implements Operando {
    @Override
    public Calculo calcular(Calculo calculo) {
        BigDecimal resultado = new BigDecimal(calculo.getOperandos().get(0));
        for (int i = 1; i < calculo.getOperandos().size(); i++) {
            resultado = resultado.subtract(new BigDecimal(calculo.getOperandos().get(i)));
        }
        calculo.setResultado(resultado);
        calculo.setOperacion(OperacionEnum.RESTA.name());
        return calculo;
    }
}
