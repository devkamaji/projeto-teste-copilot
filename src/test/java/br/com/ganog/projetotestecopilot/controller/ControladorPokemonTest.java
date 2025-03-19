package br.com.ganog.projetotestecopilot.controller;

import br.com.ganog.projetotestecopilot.port.ClientePokeApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ControladorPokemonTest {

    private MockMvc mockMvc;
    private ClientePokeApi clientePokeApi;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        clientePokeApi = Mockito.mock(ClientePokeApi.class);
        objectMapper = new ObjectMapper();
        var controladorPokemon = new ControladorPokemon(clientePokeApi, objectMapper);
        mockMvc = MockMvcBuilders.standaloneSetup(controladorPokemon).build();
    }

    @Test
    void obterImagemPokemon_Sucesso() throws Exception {
        var nomePokemon = "ditto";
        var respostaApi = "{\"sprites\":{\"front_default\":\"http://example.com/ditto.png\"}}";
        var imagemUrlEsperada = "http://example.com/ditto.png";

        when(clientePokeApi.obterPokemonPorNome(anyString())).thenReturn(ResponseEntity.ok(respostaApi));

        mockMvc.perform(get("/pokemon/{nome}", nomePokemon))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imagemUrl").value(imagemUrlEsperada));
    }

    @Test
    void obterImagemPokemon_ErroProcessamento() throws Exception {
        var nomePokemon = "ditto";
        var respostaApi = "invalid json";

        when(clientePokeApi.obterPokemonPorNome(anyString())).thenReturn(ResponseEntity.ok(respostaApi));

        mockMvc.perform(get("/pokemon/{nome}", nomePokemon))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Erro ao processar a resposta da API"));
    }
}