package com.exemplo.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    // Injetando dependencia do NinjaRepository
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Lista todos os Ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }







}
