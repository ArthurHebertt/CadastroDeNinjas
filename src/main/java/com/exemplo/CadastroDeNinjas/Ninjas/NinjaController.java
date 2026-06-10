package com.exemplo.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// Criar rotas para o usuario acessar
@RestController
@RequestMapping("/ninjas") // dominios
public class NinjaController {

    // Injetando dependencia do Service
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas () {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja (){
        return "Ninja Criado";
    }

    // Mostrar os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar os Ninjas por ID (READ)
    @GetMapping("/listarID")
    public String mostratTodosOsNinjasPorId() {
        return "Mostrar todos os Ninjas por ID";
    }

    // Alterar dados do ninja (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja por ID";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarPorID")
    public String deletarNinjaPorId() {
        return "O Ninja deletado por ID";
    }



}
