package com.lucas.modelos;

import javax.persistence.*;

import java.util.List;

@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "hospitalContratante", fetch = FetchType.EAGER)
    private List<Medico> listaMedicos;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    

    private String nome;

    
    public Hospital(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }


    public Hospital() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public List<Medico> getListaMedicos() {
        return listaMedicos;
    }


    public void setListaMedicos(List<Medico> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }


    public Endereco getEndereco() {
        return endereco;
    }


    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    

}
