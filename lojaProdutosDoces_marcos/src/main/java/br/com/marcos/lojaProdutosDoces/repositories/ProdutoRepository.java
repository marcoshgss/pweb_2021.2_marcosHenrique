package br.com.marcos.lojaProdutosDoces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marcos.lojaProdutosDoces.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
