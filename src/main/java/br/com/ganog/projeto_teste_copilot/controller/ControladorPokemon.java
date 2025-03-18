package br.com.ganog.projeto_teste_copilot.controller;

import br.com.ganog.projeto_teste_copilot.controller.dto.ImagemPadrao;
import br.com.ganog.projeto_teste_copilot.port.ClientePokeApi;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> obterPokemon(@PathVariable String nome) {
        ResponseEntity<String> response = clientePokeApi.obterPokemonPorNome(nome);
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            String frontDefault = root.path("sprites").path("front_default").asText();
            ImagemPadrao imagemResponse = new ImagemPadrao(frontDefault);
            return ResponseEntity.ok(imagemResponse);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao processar a resposta da API");
        }
    }
}