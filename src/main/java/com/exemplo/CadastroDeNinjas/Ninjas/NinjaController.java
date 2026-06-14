package com.exemplo.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Criar rotas para o usuario acessar
@RestController
@RequestMapping("/ninjas") // dominios
public class NinjaController {

    // Injetando dependencia do Service
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    // Mostrar os Ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listaDeNinjas() {
         List<NinjaDTO >lista = ninjaService.listarNinjas();
        return ResponseEntity.ok(lista);
    }

    // Mostrar os Ninjas por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<String> listarNinjasPorID(@PathVariable Long id) { // PathVariable transforma a variavel que o usuario inserier em parte da rota
       NinjaDTO ninjasPorId = ninjaService.listarNinjasPorID(id);

       if (ninjasPorId !=null)   {
           return ResponseEntity.ok("Ninja encontrado: " + ninjasPorId.getNome());
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Ninja com id: " + id + " não existe");
       }
    }


    // Alterar dados do ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninjaAlterado = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninjaAlterado !=null) {
            return ResponseEntity.ok(ninjaAlterado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id: " + id + " não existe");
        }
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorID(id)!=null ) {
            ninjaService.deletarNinjaPorID(id);
            return ResponseEntity.ok("Ninja com ID " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O Ninja com ID " + id + " não foi encontrado");
        }
    }
}
