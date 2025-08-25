package com.gamescore.repository;

import com.gamescore.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Game, Integer> {
    List<Game> findByTipo(String tipo);
    List<Game> findByNomeContainingIgnoreCase(String nome);
}