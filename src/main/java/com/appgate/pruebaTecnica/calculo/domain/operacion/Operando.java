package com.appgate.pruebaTecnica.calculo.domain.operacion;

import com.appgate.pruebaTecnica.calculo.domain.Calculo;

import java.math.BigDecimal;

public interface Operando {

    Calculo calcular(Calculo calculo);
}
