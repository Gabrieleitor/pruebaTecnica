package com.appgate.pruebaTecnica.calculo.application;

import com.appgate.pruebaTecnica.calculo.domain.Calculo;
import com.appgate.pruebaTecnica.calculo.domain.ConsultarCalculo;
import com.appgate.pruebaTecnica.calculo.infrastructure.HibernateCalculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrarOperando {
    private HibernateCalculoRepository repository;

    public RegistrarOperando(HibernateCalculoRepository repository) {
        this.repository = repository;
    }

    public void agregarOperando(Integer calculoId, Double operando) {
        ConsultarCalculo consultarCalculo = new ConsultarCalculo(repository);
        Calculo calculo = consultarCalculo.findById(calculoId);
        List<Double> operandos = calculo.getOperandos();
        operandos.add(operando);
        repository.save(calculo);
    }

}
