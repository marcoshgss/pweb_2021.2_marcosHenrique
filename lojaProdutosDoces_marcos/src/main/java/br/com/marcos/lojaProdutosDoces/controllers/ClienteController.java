package br.com.marcos.lojaProdutosDoces.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.marcos.lojaProdutosDoces.model.Cliente;
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

    @GetMapping("/listarClientes")

    public ModelAndView listarClientes() {
        List<Cliente> todasOsclientes = clienteRepo.findAll();

        ModelAndView modelAndView = new ModelAndView("listarClientes");

        modelAndView.addObject("todasOsclientes", todasOsclientes);

        return modelAndView;
    }

    @GetMapping("/adicionarCliente")
    public ModelAndView formAdicionarCliente() {
        ModelAndView modelAndView = new ModelAndView("adicionarCliente");
        modelAndView.addObject(new Cliente());
        return modelAndView;
    }

    @PostMapping("/adicionarCliente")
    public String adicionarCliente(Cliente c) {
        this.clienteRepo.save(c);
        return "redirect:/listarClientes";
    }
    @GetMapping("/editar/{id}")
    public ModelAndView formEditarCliente(@PathVariable("id") long id) {
        Cliente cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        ModelAndView modelAndView = new ModelAndView("editarCliente");
        modelAndView.addObject(cliente);
        return modelAndView;
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarCliente(@PathVariable("id") long id, Cliente c) {
        this.clienteRepo.save(c);
        return new ModelAndView("redirect:/listarClientes");
    }

    @GetMapping("/remover/{id}")
    public ModelAndView removerCliente(@PathVariable("id") long id) {
        Cliente aRemover = clienteRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        clienteRepo.delete(aRemover);
        return new ModelAndView("redirect:/listarClientes");
    }
}