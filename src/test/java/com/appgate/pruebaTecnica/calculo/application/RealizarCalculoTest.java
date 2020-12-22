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

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RealizarCalculoTest {

    private static final Integer CALCULO_ID = 1;
    private static final String SUMA = "suma";
    private static final String RESTA = "RESTA";
    private static final String DIVISION = "Division";
    private static final String MULTIPLICACION = "multiplicacion";
    private static final String POTENCIA = "POTENCIACION";
    private static final BigDecimal RESULTADO_SUMA = new BigDecimal(21);
    private static final BigDecimal RESULTADO_RESTA = new BigDecimal(-1);
    private static final BigDecimal RESULTADO_DIVISION = new BigDecimal(1);
    private static final BigDecimal RESULTADO_MULTIPLICACION = new BigDecimal(100);
    private static final BigDecimal RESULTADO_POTENCIA = new BigDecimal(10000000000L);

    @InjectMocks
    private RealizarCalculo realizarCalculo;

    @Mock
    private HibernateCalculoRepository repository;

    private void init() {
        Calculo calculo = CalculoMother.crear();
        Optional<Calculo> calculoOptional = Optional.of(calculo);
        when(repository.findById(any())).thenReturn(calculoOptional);
    }

    @Test
    void realizarCalculoValidarSuma() {
        init();
        BigDecimal resultado = realizarCalculo.lanzarCalculo(CALCULO_ID, SUMA);
        Assertions.assertEquals(RESULTADO_SUMA,resultado);
    }

    @Test
    void realizarCalculoValidarResta() {
        init();
        BigDecimal resultado = realizarCalculo.lanzarCalculo(CALCULO_ID, RESTA);
        Assertions.assertEquals(RESULTADO_RESTA,resultado);
    }

    @Test
    void realizarCalculoValidarDivision() {
        init();
        BigDecimal resultado = realizarCalculo.lanzarCalculo(CALCULO_ID, DIVISION);
        Assertions.assertEquals(RESULTADO_DIVISION,resultado);
    }

    @Test
    void realizarCalculoValidarMultiplicacion() {
        init();
        BigDecimal resultado = realizarCalculo.lanzarCalculo(CALCULO_ID, MULTIPLICACION);
        Assertions.assertEquals(RESULTADO_MULTIPLICACION,resultado);
    }

    @Test
    void realizarCalculoValidarPotencia() {
        init();
        BigDecimal resultado = realizarCalculo.lanzarCalculo(CALCULO_ID, POTENCIA);
        Assertions.assertEquals(RESULTADO_POTENCIA,resultado);
    }

}