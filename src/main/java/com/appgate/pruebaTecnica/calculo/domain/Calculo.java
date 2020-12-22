package com.appgate.pruebaTecnica.calculo.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public final class Calculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Convert(converter = ListDoubleConverte.class)
    private List<Double> operandos = new ArrayList<>();
    private String operacion;
    private BigDecimal resultado;


}
