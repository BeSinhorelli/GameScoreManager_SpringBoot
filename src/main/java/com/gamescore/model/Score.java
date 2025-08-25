package com.gamescore.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "score") // Nome exato da tabela
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_score")
    private Integer idScore;

    @ManyToOne
    @JoinColumn(name = "id_game", nullable = false)
    private Game jogo;

    @ManyToOne
    @JoinColumn(name = "id_player", nullable = false)
    private Player player;

    @Column(name = "score")
    private Integer score;

    @Column(name = "data")
    private LocalDate data;

    public Score() {}

    // Getters e Setters
    public Integer getIdScore() { return idScore; }
    public void setIdScore(Integer idScore) { this.idScore = idScore; }
    public Game getJogo() { return jogo; }
    public void setJogo(Game jogo) { this.jogo = jogo; }
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
}