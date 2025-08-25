package com.gamescore.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "jogo") // Nome exato da tabela
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "tipo", length = 50)
    private String tipo;

    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL)
    private List<Score> scores;

    public Game() {}

    // Getters e Setters
    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public List<Score> getScores() { return scores; }
    public void setScores(List<Score> scores) { this.scores = scores; }
}