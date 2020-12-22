package com.appgate.pruebaTecnica.calculo.application;

import com.appgate.pruebaTecnica.calculo.domain.Calculo;
import com.appgate.pruebaTecnica.calculo.infrastructure.HibernateCalculoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrarOperando {
    private HibernateCalculoRepository repository;

    public RegistrarOperando(HibernateCalculoRepository repository) {
        this.repository = repository;
    }

    public void agregarOperando(Integer caulculoId,Double operando) {
        Optional<Calculo> calculoOptional = repository.findById(caulculoId);
        if(calculoOptional.isPresent()){
            Calculo calculo = calculoOptional.get();
            calculo.getOperandos().add(operando);
            repository.save(calculo);
        }else{
            throw new IllegalArgumentException("No existe registro de este calculo");
        }
    }

}
