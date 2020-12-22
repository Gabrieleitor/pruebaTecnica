package com.appgate.pruebaTecnica.app.calculo;

import com.appgate.pruebaTecnica.calculo.application.CrearCalculo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CalculoPutController.class)
class CalculoPutControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CrearCalculo creator;

    @Test
    void testSolicitarCalculo() throws Exception {
        //when
        this.mockMvc.perform(put("/calculo/solicitar"))
                .andExpect(status().isCreated());
        verify(creator).crear();
    }


}