package com.appgate.pruebaTecnica.calculo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@EqualsAndHashCode
@Entity
@AllArgsConstructor
public final class Calculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Convert(converter = ListDoubleConverte.class)
    private List<Double> operandos;
    private String operacion;
    private Double resultado;


}
