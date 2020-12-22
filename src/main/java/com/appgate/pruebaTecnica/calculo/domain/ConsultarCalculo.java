package com.appgate.pruebaTecnica.calculo.domain;

import com.appgate.pruebaTecnica.calculo.infrastructure.HibernateCalculoRepository;

import java.util.Optional;

public class ConsultarCalculo {
    private HibernateCalculoRepository repository;

    public ConsultarCalculo(HibernateCalculoRepository repository) {
        this.repository = repository;
    }

    public Calculo findById(Integer caulculoId) {
        Optional<Calculo> calculoOptional = repository.findById(caulculoId);
        if (calculoOptional.isPresent()) {
            return calculoOptional.get();
        }
        throw new IllegalArgumentException("No existe registro de este calculo");
    }
}
