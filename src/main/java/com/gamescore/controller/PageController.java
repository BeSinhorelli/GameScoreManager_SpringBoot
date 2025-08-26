package com.gamescore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Página inicial
    @GetMapping("/")
    public String home() {
        return "forward:/inicial.html";
    }

    // CADASTRO
    @GetMapping("/cadastro/jogo")
    public String cadastroJogo() {
        return "forward:/cadastro/jogo.html";  // ✅ REMOVIDO /templates/
    }

    @GetMapping("/cadastro/player")
    public String cadastroPlayer() {
        return "forward:/cadastro/player.html";  // ✅ REMOVIDO /templates/
    }

    @GetMapping("/cadastro/score")
    public String cadastroScore() {
        return "forward:/cadastro/score.html";  // ✅ REMOVIDO /templates/
    }

    // LISTAGEM
    @GetMapping("/listagem/jogos")
    public String listagemJogos() {
        return "forward:/listagem/jogo.html";  // ✅ REMOVIDO /templates/
    }

    @GetMapping("/listagem/players")
    public String listagemPlayers() {
        return "forward:/listagem/player.html";  // ✅ REMOVIDO /templates/
    }

    @GetMapping("/listagem/scores")
    public String listagemScores() {
        return "forward:/listagem/score.html";  // ✅ REMOVIDO /templates/
    }

    // ALTERAR
    @GetMapping("/alterar/jogo")
    public String alterarJogo() {
        return "forward:/alterar/jogo.html";  // ✅ REMOVIDO /templates/
    }

    @GetMapping("/alterar/player")
    public String alterarPlayer() {
        return "forward:/alterar/player.html";  // ✅ REMOVIDO /templates/
    }

    @GetMapping("/alterar/score")
    public String alterarScore() {
        return "forward:/alterar/score.html";  // ✅ REMOVIDO /templates/
    }

    // EXCLUIR
    @GetMapping("/excluir/jogo")
    public String excluirJogo() {
        return "forward:/excluir/jogo.html";  // ✅ REMOVIDO /templates/
    }

    @GetMapping("/excluir/player")
    public String excluirPlayer() {
        return "forward:/excluir/player.html";  // ✅ REMOVIDO /templates/
    }

    @GetMapping("/excluir/score")
    public String excluirScore() {
        return "forward:/excluir/score.html";  // ✅ REMOVIDO /templates/
    }
}