package com.exemplo.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes") // subdominio
public class MissoesController {

    // GET - Mandar uma requisição para mostrar as missoes
    @GetMapping("/lista")
    public String listarMissoes() {
        return "Lista de Missoes";
    }

    // POST - Mandar uma requisição para criar missoes
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada com sucesso";
    }

    // PUT - Mandar requisição para alterar missoes
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    // DELETE - Mandar requisição para deletar missoes

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missao deletada com sucesso";
    }


}
