package com.example.DTO;

public class LoginResponse {
    private String mensagem;
    private String nome;

    private String cpf;
    private String cargo;
    private String email;

    public LoginResponse(String mensagem, String nome) {
        this.mensagem = mensagem;
        this.nome = nome;
    }

    public LoginResponse(String nome, String cpf, String cargo, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

