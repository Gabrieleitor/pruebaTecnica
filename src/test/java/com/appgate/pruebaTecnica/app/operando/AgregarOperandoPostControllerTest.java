package com.appgate.pruebaTecnica.app.operando;

import com.appgate.pruebaTecnica.app.calculo.CalculoPutController;
import com.appgate.pruebaTecnica.app.operacion.GenerarCalculoPostController;
import com.appgate.pruebaTecnica.calculo.application.CrearCalculo;
import com.appgate.pruebaTecnica.calculo.application.RegistrarOperando;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AgregarOperandoPostController.class)
class AgregarOperandoPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegistrarOperando registrarOperando;

    @Test
    void testAgregarOperando() throws Exception {
        AgregarOperandoPostController.Digito digito = new  AgregarOperandoPostController.Digito();
        //when
        this.mockMvc.perform(post("/operando")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(digito)))
                .andExpect(status().isOk());
        verify(registrarOperando).agregarOperando(any(),any());
    }

}