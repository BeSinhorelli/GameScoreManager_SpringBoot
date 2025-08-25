package com.gamescore.service;

import com.gamescore.model.Game;
import com.gamescore.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private JogoRepository jogoRepository;

    public List<Game> findAll() {
        return jogoRepository.findAll();
    }

    public Optional<Game> findById(Integer id) {
        return jogoRepository.findById(id);
    }

    public Game save(Game jogo) {
        return jogoRepository.save(jogo);
    }

    public void deleteById(Integer id) {
        jogoRepository.deleteById(id);
    }

    public List<Game> findByTipo(String tipo) {
        return jogoRepository.findByTipo(tipo);
    }

    public List<Game> searchByName(String nome) {
        return jogoRepository.findByNomeContainingIgnoreCase(nome);
    }
}