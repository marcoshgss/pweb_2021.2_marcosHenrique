package br.com.marcos.lojaProdutosDoces.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.marcos.lojaProdutosDoces.repositories.ClienteRepository;

@Controller
@RequestMapping("/")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepo;
    
    @GetMapping
    public String inicio() {
        return "index.html";
    }
}