package com.gamescore.service;

import com.gamescore.model.Player;
import com.gamescore.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findById(Integer id) {
        return playerRepository.findById(id);
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public void deleteById(Integer id) {
        playerRepository.deleteById(id);
    }

    public Optional<Player> findByEmail(String email) {
        return playerRepository.findByEmail(email);
    }

    public Optional<Player> findByNickname(String nickname) {
        return playerRepository.findByNickname(nickname);
    }

    public List<Player> findByPlataforma(String plataforma) {
        return playerRepository.findByPlataforma(plataforma);
    }
}