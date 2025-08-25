package com.gamescore.service;

import com.gamescore.model.Score;
import com.gamescore.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> findAll() {
        return scoreRepository.findAll();
    }

    public Optional<Score> findById(Integer id) {
        return scoreRepository.findById(id);
    }

    public Score save(Score score) {
        return scoreRepository.save(score);
    }

    public void deleteById(Integer id) {
        scoreRepository.deleteById(id);
    }

    public List<Score> findByJogoId(Integer jogoId) {
        return scoreRepository.findByJogoCodigo(jogoId);
    }

    public List<Score> findByPlayerId(Integer playerId) {
        return scoreRepository.findByPlayerId(playerId);
    }

    public List<Score> findTopScoresByJogo(Integer jogoId) {
        return scoreRepository.findTopScoresByJogo(jogoId);
    }

    public List<Score> findByMinScore(Integer minScore) {
        return scoreRepository.findByScoreGreaterThanEqual(minScore);
    }

    public List<Score> findByDate(java.time.LocalDate data) {
        return scoreRepository.findByData(data);
    }
}