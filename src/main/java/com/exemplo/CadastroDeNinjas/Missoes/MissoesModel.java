package com.exemplo.CadastroDeNinjas.Missoes;

import com.exemplo.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String dificuldade;

     // uma unica missão (a classe) para vários ninjas (elemento abaixo)
    @OneToMany (mappedBy = "missoes")
    private List<NinjaModel> ninjas;


    public MissoesModel() {
    }

    public MissoesModel(String dificuldade, String descricao) {
        this.dificuldade = dificuldade;
        this.descricao = descricao;

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

}
