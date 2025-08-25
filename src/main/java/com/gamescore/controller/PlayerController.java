package com.gamescore.controller;

import com.gamescore.model.Player;
import com.gamescore.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer id) {
        Optional<Player> player = playerService.findById(id);
        return player.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.save(player);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Integer id, @RequestBody Player playerDetails) {
        Optional<Player> player = playerService.findById(id);
        if (player.isPresent()) {
            Player existingPlayer = player.get();
            existingPlayer.setNickname(playerDetails.getNickname());
            existingPlayer.setEmail(playerDetails.getEmail());
            existingPlayer.setPlataforma(playerDetails.getPlataforma());
            return ResponseEntity.ok(playerService.save(existingPlayer));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer id) {
        if (playerService.findById(id).isPresent()) {
            playerService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Player> getPlayerByEmail(@PathVariable String email) {
        Optional<Player> player = playerService.findByEmail(email);
        return player.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nickname/{nickname}")
    public ResponseEntity<Player> getPlayerByNickname(@PathVariable String nickname) {
        Optional<Player> player = playerService.findByNickname(nickname);
        return player.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/plataforma/{plataforma}")
    public List<Player> getPlayersByPlataforma(@PathVariable String plataforma) {
        return playerService.findByPlataforma(plataforma);
    }
}