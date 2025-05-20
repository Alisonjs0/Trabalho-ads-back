package com.example.DTO;

public class LoginResponse {
    private String mensagem;
    private String nome;

    public LoginResponse(String mensagem, String nome) {
        this.mensagem = mensagem;
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
