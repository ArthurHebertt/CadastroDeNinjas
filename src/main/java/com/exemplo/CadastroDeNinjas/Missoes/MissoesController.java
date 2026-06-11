package com.exemplo.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes") // subdominio
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET - Mandar uma requisição para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    // POST - Mandar uma requisição para criar missoes
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao) {
        return missoesService.criarMissoes(missao);
    }

    // PUT - Mandar requisição para alterar missoes
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    // DELETE - Mandar requisição para deletar missoes

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(Long id) {
         missoesService.deletarMissoes(id);
    }


}
