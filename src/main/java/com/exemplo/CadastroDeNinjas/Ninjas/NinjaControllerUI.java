package com.exemplo.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping ("/ninjas/ui")
public class NinjaControllerUI {

    private final NinjaService ninjaService;

    public NinjaControllerUI(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listaDeNinjas(Model model) {
        List<NinjaDTO >ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas"; // Tem que retornar o nome da pagina que renderiza
    }

    // Deletar Ninja (DELETE)
    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorID(id);
        return "redirect:/ninjas/ui/listar"; // redireciona o usuario a lista apos deletar um ninja


    }
    @GetMapping("/listar/{id}")
    public String listarNinjasPorId(@PathVariable Long id, Model model) {
        System.out.println("Entrou no método de detalhes");
        NinjaDTO ninja = ninjaService.listarNinjasPorID(id);
        model.addAttribute("ninja", ninja);
        return "detalhesNinja";
    }

    // Adicionar Ninja (CREATE)
    @GetMapping("/adicionar")
    public String mostrarFormulario (Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(@ModelAttribute NinjaDTO ninja) {
       ninjaService.criarNinja(ninja);
       return "redirect:/ninjas/ui/listar";
    }


    @GetMapping("/teste")
    public String teste() {
        System.out.println("Teste funcionando");
        return "listarNinjas";}
}
