package com.appgate.pruebaTecnica.app.calculo;

import com.appgate.pruebaTecnica.calculo.application.CrearCalculo;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/calculo")
public class CalculoPutController {

    private final CrearCalculo creator;

    public CalculoPutController(CrearCalculo creator) {
        this.creator = creator;
    }


    @PutMapping("/solicitar")
    public ResponseEntity<?> index() {
        try {
            Integer calculoId = creator.crear();
            return new ResponseEntity<>(calculoId, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
