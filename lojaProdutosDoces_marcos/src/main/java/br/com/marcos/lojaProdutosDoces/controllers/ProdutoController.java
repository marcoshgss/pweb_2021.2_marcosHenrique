package br.com.marcos.lojaProdutosDoces.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.marcos.lojaProdutosDoces.model.Produto;
import br.com.marcos.lojaProdutosDoces.repositories.ProdutoRepository;



@Controller
@RequestMapping("/")
public class ProdutoController {
    @Autowired
    ProdutoRepository produtRepo;

    @GetMapping("/listarProdutos")
    
    public ModelAndView listarProdutos() {
        List<Produto> todosOsprodutos = produtRepo.findAll();

        ModelAndView modelAndView = new ModelAndView("listarProdutos");

        modelAndView.addObject("todosOsprodutos", todosOsprodutos);

        return modelAndView;
    }
    
    @GetMapping("/adicionarProduto")
    public ModelAndView formAdicionarProduto() {
        ModelAndView modelAndView = new ModelAndView("adicionarProduto");
        modelAndView.addObject(new Produto());
        return modelAndView;
    }

    @PostMapping("/adicionarProduto")
    public String adicionarProduto(Produto p) {
        this.produtRepo.save(p);
        return "redirect:/listarProdutos";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView formEditarProduto(@PathVariable("id") long id) {
        Produto produto = produtRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        ModelAndView modelAndView = new ModelAndView("editarProduto");
        modelAndView.addObject(produto);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editarProduto(@PathVariable("id") long id, Produto p) {
        this.produtRepo.save(p);
        return new ModelAndView("redirect:/listarProdutos");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView removerProduto(@PathVariable("id") long id) {
        Produto aRemover = produtRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
                produtRepo.delete(aRemover);
        return new ModelAndView("redirect:/listarProdutos");
    }

}
