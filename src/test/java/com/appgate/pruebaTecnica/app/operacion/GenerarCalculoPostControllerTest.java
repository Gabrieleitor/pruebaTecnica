package com.appgate.pruebaTecnica.app.operacion;

import com.appgate.pruebaTecnica.app.calculo.CalculoPutController;
import com.appgate.pruebaTecnica.calculo.application.CrearCalculo;
import com.appgate.pruebaTecnica.calculo.application.RealizarCalculo;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = GenerarCalculoPostController.class)
class GenerarCalculoPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RealizarCalculo realizarCalculo;



    @Test
    void testRealizarCalculo() throws Exception {
        GenerarCalculoPostController.Operacion operacion = new GenerarCalculoPostController.Operacion();
        //when
        this.mockMvc.perform(post("/operacion")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(operacion)))
                .andExpect(status().isOk());
        verify(realizarCalculo).lanzarCalculo(any(),any());
    }

}