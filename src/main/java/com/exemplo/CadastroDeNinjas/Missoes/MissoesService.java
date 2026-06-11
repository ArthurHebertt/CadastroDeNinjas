package com.exemplo.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Criar Missoes
    public MissoesModel criarMissoes (MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    // Listar todas as missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    // Deletar missoes
    public void deletarMissoes(Long id) {
        missoesRepository.deleteById(id);
    }
}
