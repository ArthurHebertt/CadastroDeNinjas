package com.exemplo.CadastroDeNinjas.Missoes;

import com.exemplo.CadastroDeNinjas.Ninjas.NinjaDTO;
import com.exemplo.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes") // subdominio
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET - Mandar uma requisição para mostrar as missoes
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listaDeMissoes() {
        List<MissoesDTO>lista = missoesService.listarMissoes();
        return ResponseEntity.ok(lista);
    }

    // Listar Missao por Id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        MissoesDTO missaoPorId = missoesService.procurarMissaoPorId(id);
        if (missaoPorId != null) {
            return  ResponseEntity.ok(missaoPorId);
        } else { return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão com id: " + id + " não existe");
     }

    }

    // POST - Mandar uma requisição para criar missoes
    @PostMapping("/criar")
    public ResponseEntity <String> criarMissao(@RequestBody MissoesDTO missao) {
        MissoesDTO novaMissao = missoesService.criarMissoes(missao);
        return ResponseEntity.ok("Missão criada com sucesso");
    }

    // PUT - Mandar requisição para alterar missoes
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        MissoesDTO missoesDTO = missoesService.alterarMissao(id, missaoAtualizada);
        if (missoesDTO != null) {
            return ResponseEntity.ok("Missão com id: " + id + " foi atualizada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão não foi encontrada");

        }
    }

    // DELETE - Mandar requisição para deletar missoes

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {

        if (missoesService.procurarMissaoPorId(id) != null) {
             missoesService.deletarMissoes(id);
             return ResponseEntity.ok("Missão foi deletada");
         } else {return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão com id: " + id + "  foi não encontrada");
        }
    }


}
