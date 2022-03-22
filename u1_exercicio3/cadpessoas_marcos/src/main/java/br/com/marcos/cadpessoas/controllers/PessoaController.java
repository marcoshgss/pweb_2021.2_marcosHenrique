package br.com.marcos.cadpessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.marcos.cadpessoas.model.Pessoa;
import br.com.marcos.cadpessoas.repositories.PessoaRepository;

@Controller
@RequestMapping("/")
public class PessoaController {
    @Autowired
    PessoaRepository pessoaRepo;

    PessoaController(PessoaRepository pessoaR) {
        this.pessoaRepo = pessoaR;
    }@GetMapping

    public String inicio(){
        return "index.html";
    }

    @GetMapping("/listarPessoas")

    public ModelAndView listarPessoas() {
        List <Pessoa> todasAsPessoas = pessoaRepo.findAll();

        ModelAndView modelAndView = new ModelAndView("listarPessoas");

        modelAndView.addObject("todasAsPessoas", todasAsPessoas);

        return modelAndView;
    }
}
