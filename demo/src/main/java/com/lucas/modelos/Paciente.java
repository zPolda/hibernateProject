package com.lucas.modelos;

import javax.persistence.*;

import com.lucas.interfaces.Cansado;


@Entity
@DiscriminatorValue(value = "paciente")
public class Paciente extends Usuario implements Cansado {
    private String peso, altura;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Paciente(){
    }

    
    public Paciente(String nome, String idade, String cpf, String username, String senha, boolean privilegio,
            String peso, String altura, Endereco endereco) {
        super(nome, idade, cpf, username, senha, privilegio);
        this.peso = peso;
        this.altura = altura;
        this.endereco = endereco;
    }
    
    

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", username=" + username + ", senha="
                + senha + ", privilegio=" + privilegio + "]";
    }

    @Override
    public void estouCansado() {
        System.out.println("Estou cansado");
        
    }

    @Override
    public void naoEstouCansado() {
        System.out.println("Nao estou cansado");
    }
}
