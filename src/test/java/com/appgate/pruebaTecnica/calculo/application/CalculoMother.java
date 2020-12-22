package com.appgate.pruebaTecnica.calculo.application;

import com.appgate.pruebaTecnica.calculo.domain.Calculo;

import java.util.Arrays;

public class CalculoMother {
    private static final Integer CALCULO_ID = 1;
    private static final double VALOR_UNO = 10.0;
    private static final double VALOR_DOS = 10.0;
    private static final double VALOR_TRES = 1.0;



    public static Calculo crear() {
        Calculo calculo = new Calculo();
        calculo.setId(CALCULO_ID);
        calculo.setOperandos(Arrays.asList(VALOR_UNO, VALOR_DOS, VALOR_TRES));
        return calculo;
    }
}
