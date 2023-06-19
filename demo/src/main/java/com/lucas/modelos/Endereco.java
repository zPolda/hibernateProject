package com.lucas.modelos;

import javax.persistence.*;


@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeUser, logradouro, bairro, cep, numero, complemento, cidade, uf;

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getNomeUser() {
        return nomeUser;
    }



    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }



    public String getLogradouro() {
        return logradouro;
    }



    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }



    public String getBairro() {
        return bairro;
    }



    public void setBairro(String bairro) {
        this.bairro = bairro;
    }



    public String getCep() {
        return cep;
    }



    public void setCep(String cep) {
        this.cep = cep;
    }



    public String getNumero() {
        return numero;
    }



    public void setNumero(String numero) {
        this.numero = numero;
    }



    public String getComplemento() {
        return complemento;
    }



    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }



    public String getCidade() {
        return cidade;
    }



    public void setCidade(String cidade) {
        this.cidade = cidade;
    }



    public String getUf() {
        return uf;
    }



    public void setUf(String uf) {
        this.uf = uf;
    }



    public Endereco(String nomeUser, String logradouro, String bairro, String cep, String numero, String complemento,
            String cidade, String uf) {
        this.nomeUser = nomeUser;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
    }

    

    public Endereco() {
    }



    @Override
    public String toString() {
        return "Endereco [nomeUser=" + nomeUser + ", logradouro=" + logradouro + ", bairro=" + bairro + ", cep=" + cep
                + ", numero=" + numero + ", complemento=" + complemento + ", cidade=" + cidade + ", uf=" + uf + "]";
    }

    

}
