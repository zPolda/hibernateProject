package com.lucas.modelos;

import javax.persistence.*;


@Entity
@DiscriminatorValue(value = "administrador")
public class Administrador extends Usuario{

    public Administrador(){

    }
    public Administrador(String nome, String idade, String cpf, String username, String senha, boolean privilegio) {
        super(nome, idade, cpf, username, senha, privilegio);
        //TODO Auto-generated constructor stub
    }
    
}
