package com.lucas.modelos;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Usuario paciente;

    @OneToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Usuario getPaciente() {
        return paciente;
    }


    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }


    public Medico getMedico() {
        return medico;
    }


    public void setMedico(Medico medico) {
        this.medico = medico;
    }


    public Date getData() {
        return data;
    }


    public void setData(Date data) {
        this.data = data;
    }


    private Date data;


    public Consulta(Usuario paciente, Medico medico, Date data) {
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
    }


    public Consulta() {
    }

    
}
