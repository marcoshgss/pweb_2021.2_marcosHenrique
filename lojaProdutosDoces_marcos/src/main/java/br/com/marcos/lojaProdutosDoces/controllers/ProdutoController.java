package br.com.marcos.lojaProdutosDoces.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.marcos.lojaProdutosDoces.repositories.ProdutoRepository;



@Controller
@RequestMapping("/")
public class ProdutoController {
    @Autowired
    ProdutoRepository produtRepo;

    @GetMapping
    public String inicio() {
        return "index.html";
    }

    





}
