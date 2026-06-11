package com.exemplo.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    // Injetando dependencia do NinjaRepository
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Criar um novo Ninja
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // Lista todos os Ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // Listar Ninja por ID
    public NinjaModel listarNinjasPorID(Long id) {
        Optional<NinjaModel> ninjaPorID = ninjaRepository.findById(id);
        return ninjaPorID.orElse(null);
    }

    // Atualizar Ninja


    // Deletar Ninja - Tem que ser um metodo VOID
    public void deletarNinjaPorID(Long id) {
        ninjaRepository.deleteById(id);
    }







}
