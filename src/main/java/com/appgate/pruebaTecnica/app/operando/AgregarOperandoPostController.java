package com.appgate.pruebaTecnica.app.operando;

import com.appgate.pruebaTecnica.calculo.application.RegistrarOperando;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/operando")
public final class AgregarOperandoPostController {

    private final RegistrarOperando registrarOperando;

    public AgregarOperandoPostController(RegistrarOperando registrarOperando) {
        this.registrarOperando = registrarOperando;
    }

    @PostMapping
    public ResponseEntity<String> index(@RequestBody Digito request) {
        try {
            registrarOperando.agregarOperando(request.getCalculoId(), request.getOperando());
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Data
    static final class Digito {
        private Integer calculoId;
        private Double operando;
    }
}
