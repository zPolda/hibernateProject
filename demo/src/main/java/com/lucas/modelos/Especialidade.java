package com.lucas.modelos;

import java.util.ArrayList;

import javax.persistence.*;

import java.util.List;

@Entity
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "especialidades", fetch = FetchType.EAGER)
    private List<Medico> medicos = new ArrayList<Medico>();

    public ArrayList<Medico> verificarMedico() {
       ArrayList<Medico> infoId = new ArrayList<Medico>();
       for (Medico medico : medicos) {
        infoId.add(medico);
       }

       return infoId;
    }


    public void adicionarMedicoAoList(Medico med){
        medicos.add(med);
    }

    private String nome, codigo;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Especialidade(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public Especialidade() {
    }

    

}
