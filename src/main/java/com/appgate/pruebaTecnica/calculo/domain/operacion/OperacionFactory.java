package com.appgate.pruebaTecnica.calculo.domain.operacion;

public class OperacionFactory {

    public Operando getOperando(OperacionEnum operacion) {
        switch (operacion) {
            case SUMA:
                return new SumaOperando();
            case RESTA:
                return new RestaOperando();
            case DIVISION:
                return new DivisionOperando();
            case MULTIPLICACION:
                return new MultiplicacionOperando();
            case POTENCIACION:
                return new PotenciacionOperando();
            default:
                return null;
        }
    }
}
