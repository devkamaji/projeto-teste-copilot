package br.com.ganog.projeto_teste_copilot.port;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokeapi", url = "https://pokeapi.co/api/v2")
public interface ClientePokeApi {

    /**
     * Obtém informações de um Pokémon pelo nome.
     *
     * @param nome Nome do Pokémon
     * @return ResponseEntity contendo a resposta da API como String
     */
    @GetMapping("/pokemon/{nome}")
    ResponseEntity<String> obterPokemonPorNome(@PathVariable("nome") String nome);
}