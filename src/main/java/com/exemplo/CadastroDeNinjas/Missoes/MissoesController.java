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
    public List<MissoesDTO> listarMissoes() {
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO listarPorId(@PathVariable Long id) {
        return missoesService.procurarMissaoPorId(id);
    }

    // POST - Mandar uma requisição para criar missoes
    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao) {
        return missoesService.criarMissoes(missao);
    }

    // PUT - Mandar requisição para alterar missoes
    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        return missoesService.alterarMissao(id, missaoAtualizada);
    }

    // DELETE - Mandar requisição para deletar missoes

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
         missoesService.deletarMissoes(id);
    }


}
