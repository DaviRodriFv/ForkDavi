package com;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiKeyAuthTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void devePermitirAcessoComApiKeyValida() throws Exception {
        mockMvc.perform(get("/carro")
                .header("X-API-KEY", "minha-chave-secreta-123"))
                .andExpect(status().isOk());
    }

    @Test
    void deveNegarAcessoComApiKeyInvalida() throws Exception {
        mockMvc.perform(get("/carro")
                .header("X-API-KEY", "chave_errada"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void deveNegarAcessoSemApiKey() throws Exception {
        mockMvc.perform(get("/carro"))
                .andExpect(status().isUnauthorized());
    }
}