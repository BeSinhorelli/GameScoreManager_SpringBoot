package com.gamescore.controller;

import com.gamescore.model.Score;
import com.gamescore.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public List<Score> getAllScores() {
        return scoreService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Score> getScoreById(@PathVariable Integer id) {
        Optional<Score> score = scoreService.findById(id);
        return score.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Score createScore(@RequestBody Score score) {
        return scoreService.save(score);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Score> updateScore(@PathVariable Integer id, @RequestBody Score scoreDetails) {
        Optional<Score> optionalScore = scoreService.findById(id);

        if (optionalScore.isPresent()) {
            Score score = optionalScore.get();

            // Atualizar os campos necessários
            if (scoreDetails.getScore() != null) {
                score.setScore(scoreDetails.getScore());
            }
            if (scoreDetails.getData() != null) {
                score.setData(scoreDetails.getData());
            }
            if (scoreDetails.getPlayer() != null) {
                score.setPlayer(scoreDetails.getPlayer());
            }
            if (scoreDetails.getJogo() != null) {
                score.setJogo(scoreDetails.getJogo());
            }

            Score updatedScore = scoreService.save(score);
            return ResponseEntity.ok(updatedScore);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable Integer id) {
        if (scoreService.findById(id).isPresent()) {
            scoreService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/jogo/{jogoId}")
    public List<Score> getScoresByJogo(@PathVariable Integer jogoId) {
        return scoreService.findByJogoId(jogoId);
    }

    @GetMapping("/player/{playerId}")
    public List<Score> getScoresByPlayer(@PathVariable Integer playerId) {
        return scoreService.findByPlayerId(playerId);
    }

    @GetMapping("/jogo/{jogoId}/top")
    public List<Score> getTopScoresByJogo(@PathVariable Integer jogoId) {
        return scoreService.findTopScoresByJogo(jogoId);
    }

    @GetMapping("/min-score/{minScore}")
    public List<Score> getScoresAbove(@PathVariable Integer minScore) {
        return scoreService.findByMinScore(minScore);
    }

    @GetMapping("/date/{date}")
    public List<Score> getScoresByDate(@PathVariable java.time.LocalDate date) {
        return scoreService.findByDate(date);
    }
}