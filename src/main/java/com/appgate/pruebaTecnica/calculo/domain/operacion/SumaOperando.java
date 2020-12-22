package com.appgate.pruebaTecnica.calculo.domain.operacion;

import com.appgate.pruebaTecnica.calculo.domain.Calculo;

import java.math.BigDecimal;

public class SumaOperando implements Operando {

    @Override
    public Calculo calcular(Calculo calculo) {
       BigDecimal resultado =BigDecimal.ZERO;
        for (Double operando : calculo.getOperandos()) resultado = resultado.add(new BigDecimal(operando));
        calculo.setResultado(resultado);
        calculo.setOperacion(OperacionEnum.SUMA.name());
        return calculo;
    }
}
