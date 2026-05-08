package com.exemplo.CadastroDeNinjas.Missoes;

import com.exemplo.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String dificuldade;

     // uma unica missão (a classe) para vários ninjas (elemento abaixo)
    @OneToMany (mappedBy = "missoes")
    private List<NinjaModel> ninjas;




}
