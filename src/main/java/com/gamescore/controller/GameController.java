package com.gamescore.controller;

import com.gamescore.model.Game;
import com.gamescore.dto.GameDTO;
import com.gamescore.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jogos")
@CrossOrigin(origins = "http://localhost") // Adicione para permitir requests do frontend
public class GameController {

    @Autowired
    private GameService jogoService;

    // Método para converter Entity para DTO
    private GameDTO convertToDTO(Game game) {
        return new GameDTO(game.getCodigo(), game.getNome(), game.getTipo());
    }

    @GetMapping
    public List<GameDTO> getAllJogos() {
        return jogoService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getJogoById(@PathVariable Integer id) {
        Optional<Game> jogo = jogoService.findById(id);
        return jogo.map(game -> ResponseEntity.ok(convertToDTO(game)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GameDTO createJogo(@RequestBody Game jogo) {
        Game savedGame = jogoService.save(jogo);
        return convertToDTO(savedGame);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameDTO> updateJogo(@PathVariable Integer id, @RequestBody Game jogoDetails) {
        Optional<Game> jogo = jogoService.findById(id);
        if (jogo.isPresent()) {
            Game existingJogo = jogo.get();
            existingJogo.setNome(jogoDetails.getNome());
            existingJogo.setTipo(jogoDetails.getTipo());
            Game updatedGame = jogoService.save(existingJogo);
            return ResponseEntity.ok(convertToDTO(updatedGame));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJogo(@PathVariable Integer id) {
        if (jogoService.findById(id).isPresent()) {
            jogoService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/tipo/{tipo}")
    public List<GameDTO> getJogosByTipo(@PathVariable String tipo) {
        return jogoService.findByTipo(tipo).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public List<GameDTO> searchJogosByName(@RequestParam String nome) {
        return jogoService.searchByName(nome).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}