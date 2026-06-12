package com.exemplo.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO) {

        MissoesModel missoesModel = new MissoesModel();

        missoesModel.setId(missoesDTO.getId());
        missoesModel.setDescricao(missoesDTO.getDescricao());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNinjas(missoesDTO.getNinja());

        return missoesModel;

    }

    public MissoesDTO map(MissoesModel missoesModel) {

        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setDescricao(missoesModel.getDescricao());
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNinja(missoesDTO.getNinja());

        return missoesDTO;

    }


}

