package com.appgate.pruebaTecnica.calculo.application;


import com.appgate.pruebaTecnica.calculo.domain.Calculo;
import com.appgate.pruebaTecnica.calculo.infrastructure.HibernateCalculoRepository;
import org.springframework.stereotype.Service;

@Service
public class CrearCalculo {

    private HibernateCalculoRepository repository;

    public CrearCalculo(HibernateCalculoRepository repository) {
        this.repository = repository;
    }

    public Integer crear() {
        Calculo calculo = new Calculo();
        repository.save(calculo);
        return calculo.getId();
    }
}
