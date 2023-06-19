package com.lucas.modelos;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    protected String nome, idade, cpf, username, senha;
    protected boolean privilegio;
    
    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", username=" + username + ", senha="
                + senha + ", privilegio=" + privilegio + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(boolean privilegio) {
        this.privilegio = privilegio;
    }

    public Usuario(String nome, String idade, String cpf, String username, String senha, boolean privilegio) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.username = username;
        this.senha = senha;
        this.privilegio = privilegio;
    };
}
