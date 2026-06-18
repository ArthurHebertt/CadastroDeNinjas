package com.exemplo.CadastroDeNinjas.Missoes;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("missoes/ui")
public class MissoesControllerUI {
    private MissoesService missoesService;

    public MissoesControllerUI(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String listaDeMissoes(Model model) {
        List<MissoesDTO>missoes = missoesService.listarMissoes();
        model.addAttribute("missoes" ,missoes);
        return "listarMissoes";
    }

}
