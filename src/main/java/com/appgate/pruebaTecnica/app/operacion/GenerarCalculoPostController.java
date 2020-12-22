package com.appgate.pruebaTecnica.app.operacion;

import com.appgate.pruebaTecnica.app.operando.AgregarOperandoPostController;
import com.appgate.pruebaTecnica.calculo.application.CrearCalculo;
import com.appgate.pruebaTecnica.calculo.application.RealizarCalculo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Log4j2
@RestController
@RequestMapping("/operacion")
public final class GenerarCalculoPostController {

    private final RealizarCalculo realizarCalculo;

    public GenerarCalculoPostController(RealizarCalculo realizarCalculo) {
        this.realizarCalculo = realizarCalculo;
    }

    @PostMapping
    public ResponseEntity<?> index(@RequestBody Operacion request) {
        try {
            BigDecimal respuesta = realizarCalculo.lanzarCalculo(request.getCalculoId(), request.getOperador());
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Data
    static final class Operacion {
        private Integer calculoId;
        private String operador;
    }
}
