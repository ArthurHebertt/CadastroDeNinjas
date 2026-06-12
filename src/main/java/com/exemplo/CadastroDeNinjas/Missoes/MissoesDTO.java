package com.exemplo.CadastroDeNinjas.Missoes;
import com.exemplo.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {


    private Long id;
    private String descricao;
    private String dificuldade;
    private List <NinjaModel> ninja;

}
