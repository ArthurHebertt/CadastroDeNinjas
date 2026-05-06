package com.exemplo.CadastroDeNinjas.Ninjas;


import com.exemplo.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;


// JPA = Java Persistence API

@Entity // transforma toda a classe em entidade do DB
@Table(name = "tb_cadastro") // transforma a entidade em tabela que vai receber todos os valores
public class NinjaModel {

    @Id // indica que o atributo abaixo dele vai ser usado como ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Passa estrategia de como o ID vai ser gerado
    private Long id;
    private String nome;
    private String email;
    private int idade;

    // @ManyToOne um ninja (classe) tem uma unica missão (elemento abaixo)
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing Key ou chave estrangeira
    private MissoesModel missoes;

    public NinjaModel() { // no args constructor
    }

    public NinjaModel(String nome, String email, int idade) { // all args constructor
        this.nome = nome;
        this.email = email;
        this.idade = idade;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
