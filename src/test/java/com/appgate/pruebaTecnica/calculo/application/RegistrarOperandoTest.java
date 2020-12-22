package com.appgate.pruebaTecnica.calculo.application;

import com.appgate.pruebaTecnica.calculo.domain.Calculo;
import com.appgate.pruebaTecnica.calculo.infrastructure.HibernateCalculoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RegistrarOperandoTest {
    private static final Integer CALCULO_ID = 1;
    private static final Double VALOR_OPERANDO = 21.0;
    private static final Integer TAMANO_LIST = 1;


    @InjectMocks
    private RegistrarOperando registrarOperando;

    @Mock
    private HibernateCalculoRepository repository;

    @Spy
    List<Double> spyList = new ArrayList<>();


    @Test
    void registrarCalculoValidarTamanoList() {
        Calculo calculo = new Calculo();
        calculo.setOperandos(spyList);
        Optional<Calculo> calculoOptional = Optional.of(calculo);
        when(repository.save(any())).thenReturn(calculo);
        when(repository.findById(any())).thenReturn(calculoOptional);
        registrarOperando.agregarOperando(CALCULO_ID,VALOR_OPERANDO);
        Assertions.assertEquals(TAMANO_LIST,spyList.size());

    }

}