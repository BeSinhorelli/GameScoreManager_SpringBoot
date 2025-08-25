package com.gamescore.controller;

import com.gamescore.model.Game;
import com.gamescore.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jogos")
public class GameController {

    @Autowired
    private GameService jogoService;

    @GetMapping
    public List<Game> getAllJogos() {
        return jogoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getJogoById(@PathVariable Integer id) {
        Optional<Game> jogo = jogoService.findById(id);
        return jogo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Game createJogo(@RequestBody Game jogo) {
        return jogoService.save(jogo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateJogo(@PathVariable Integer id, @RequestBody Game jogoDetails) {
        Optional<Game> jogo = jogoService.findById(id);
        if (jogo.isPresent()) {
            Game existingJogo = jogo.get();
            existingJogo.setNome(jogoDetails.getNome());  // Corrigido: setNome (não setHome)
            existingJogo.setTipo(jogoDetails.getTipo());
            return ResponseEntity.ok(jogoService.save(existingJogo));
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
    public List<Game> getJogosByTipo(@PathVariable String tipo) {
        return jogoService.findByTipo(tipo);
    }

    @GetMapping("/search")
    public List<Game> searchJogosByName(@RequestParam String nome) {
        return jogoService.searchByName(nome);
    }
}