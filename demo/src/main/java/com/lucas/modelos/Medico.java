package com.lucas.modelos;

import javax.persistence.*;



import java.util.ArrayList;
import java.util.List;


@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getCrm() {
        return crm;
    }


    public void setCrm(String crm) {
        this.crm = crm;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }


    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }


    private String crm, nome;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "especialidade_medico",
                joinColumns = {@JoinColumn(name="medico_id")},
                inverseJoinColumns = {@JoinColumn(name="especialidade_id")})
    private List<Especialidade> especialidades = new ArrayList<Especialidade>();

    public void especialidadeNova(Especialidade esp){
        especialidades.add(esp);
    }

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospitalContratante;

    public Hospital getHospitalContratante() {
        return hospitalContratante;
    }


    public void setHospitalContratante(Hospital hospitalContratante) {
        this.hospitalContratante = hospitalContratante;
    }


    public Medico(String crm, String nome, Hospital hospitalContratante) {
        this.crm = crm;
        this.nome = nome;
        this.hospitalContratante = hospitalContratante;
    }


    public Medico() {
    }

    

}
