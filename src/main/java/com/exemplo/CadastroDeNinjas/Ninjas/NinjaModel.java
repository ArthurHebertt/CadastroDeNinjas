package com.exemplo.CadastroDeNinjas.Ninjas;

import com.exemplo.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// JPA = Java Persistence API

@Entity // transforma toda a classe em entidade do DB
@Table(name = "tb_cadastro") // transforma a entidade em tabela que vai receber todos os valores
@NoArgsConstructor // cria construtor vazio automaticamente
@AllArgsConstructor // cria contrunstores com todos os argumentos e preenche automaticamente
@Data // cria os getters e setters dos argumentos
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


}
