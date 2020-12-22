package com.appgate.pruebaTecnica.calculo.application;

import com.appgate.pruebaTecnica.calculo.domain.Calculo;
import com.appgate.pruebaTecnica.calculo.domain.ConsultarCalculo;
import com.appgate.pruebaTecnica.calculo.domain.operacion.OperacionEnum;
import com.appgate.pruebaTecnica.calculo.domain.operacion.OperacionFactory;
import com.appgate.pruebaTecnica.calculo.domain.operacion.Operando;
import com.appgate.pruebaTecnica.calculo.infrastructure.HibernateCalculoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RealizarCalculo {

    private HibernateCalculoRepository repository;

    public RealizarCalculo(HibernateCalculoRepository repository) {
        this.repository = repository;
    }

    public BigDecimal lanzarCalculo(Integer calculoId, String operador) {
        ConsultarCalculo consultarCalculo = new ConsultarCalculo(repository);
        Calculo calculo = consultarCalculo.findById(calculoId);
        CrearOperador crearOperador = new CrearOperador();
        OperacionEnum operacionEnum = crearOperador.crear(operador);
        OperacionFactory operacionFactory = new OperacionFactory();
        Operando operando = operacionFactory.getOperando(operacionEnum);
        operando.calcular(calculo);
        repository.save(calculo);
        return calculo.getResultado();
    }
}
