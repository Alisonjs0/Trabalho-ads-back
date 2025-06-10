package com.example.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nome", length = 100 , nullable = false)
    private String nome;

    @Column(name = "cpf", length = 11, unique = true, nullable = false, columnDefinition = "CHAR(11)")
    private String cpf;

    @Column(name = "cargo", length = 100, nullable = false)
    private String cargo;

    @Column(name = "email", length = 150, unique = true, nullable = false)
    private String email;

    private String senha;

    public UserEntity() {}

    public UserEntity(String nome, String cpf, String cargo, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

//    public String getSetor() {
//        return setor;
//    }
//
//    public void setSetor(String setor) {
//        this.setor = setor;
//    }
}
