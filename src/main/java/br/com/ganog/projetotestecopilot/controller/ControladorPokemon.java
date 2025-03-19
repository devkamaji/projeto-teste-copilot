package br.com.ganog.projetotestecopilot.controller;

import br.com.ganog.projetotestecopilot.controller.dto.ImagemPadrao;
import br.com.ganog.projetotestecopilot.port.ClientePokeApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequiredArgsConstructor
public class ControladorPokemon {

    private final ClientePokeApi clientePokeApi;
    private final ObjectMapper objectMapper;

    /**
     * Obtém a URL da imagem de um Pokémon pelo nome.
     *
     * @param nome Nome do Pokémon
     * @return ResponseEntity contendo a URL da imagem ou uma mensagem de erro
     */
    @GetMapping("/pokemon/{nome}")
    public ResponseEntity<?> obterImagemPokemon(@PathVariable String nome) {
        final var response = clientePokeApi.obterPokemonPorNome(nome);
        try {
            final var root = objectMapper.readTree(response.getBody());
            final var urlImagem = root.path("sprites").path("front_default").asText();
            return ok(new ImagemPadrao(urlImagem));
        } catch (Exception e) {
            return status(500).body("Erro ao processar a resposta da API");
        }
    }
}