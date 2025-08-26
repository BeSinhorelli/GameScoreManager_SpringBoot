package com.gamescore.dto;

public class GameDTO {
    private Integer codigo;
    private String nome;
    private String tipo;

    // Construtor
    public GameDTO(Integer codigo, String nome, String tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
    }

    // Getters
    public Integer getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
}