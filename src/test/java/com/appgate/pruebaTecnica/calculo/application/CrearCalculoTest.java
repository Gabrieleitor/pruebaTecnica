package com.appgate.pruebaTecnica.calculo.application;

import com.appgate.pruebaTecnica.calculo.domain.Calculo;
import com.appgate.pruebaTecnica.calculo.infrastructure.HibernateCalculoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CrearCalculoTest {
    private static final Integer CALCULO_ID = 1;

    @InjectMocks
    private CrearCalculo crearCalculo;

    @Mock
    private HibernateCalculoRepository repository;


    @Test
    void creandoCalculoValidarId() {
        Calculo calculo = new Calculo();
        calculo.setId(CALCULO_ID);
        when(repository.save(any())).thenReturn(calculo);
        Integer calculoId = crearCalculo.crear();
        Assertions.assertEquals(CALCULO_ID,calculoId);
    }

}