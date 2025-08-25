package com.gamescore.repository;

import com.gamescore.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findByEmail(String email);
    Optional<Player> findByNickname(String nickname);
    List<Player> findByPlataforma(String plataforma);
}