package com.gamescore.repository;

import com.gamescore.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    List<Score> findByJogoCodigo(Integer codigoJogo);
    List<Score> findByPlayerId(Integer idPlayer);
    List<Score> findByScoreGreaterThanEqual(Integer minScore);

    @Query("SELECT s FROM Score s WHERE s.jogo.codigo = :codigoJogo ORDER BY s.score DESC")
    List<Score> findTopScoresByJogo(Integer codigoJogo);

    List<Score> findByData(LocalDate data);
}