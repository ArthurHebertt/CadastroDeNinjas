package com.exemplo.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas") // dominios
public class NinjaController {

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
    public String mostratTodosOsNinjas() {
        return "Mostrar todos os Ninjas";
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
