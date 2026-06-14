package com.exemplo.CadastroDeNinjas.Missoes;

import com.exemplo.CadastroDeNinjas.Ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descrição")
    private String descricao;

    @Column(name = "dificuldade")
    private String dificuldade;

     // uma unica missão (a classe) para vários ninjas (elemento abaixo)
    @OneToMany (mappedBy = "missoes")
    @JsonIgnore // Ignora a serialização para não causar o erro de looping infinito
    private List<NinjaModel> ninjas;




}
