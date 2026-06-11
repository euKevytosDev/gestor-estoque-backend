package com.gestor.estoque.controller;

import com.gestor.estoque.model.Produto;

// Importando o repository que acabamos de criar
import com.gestor.estoque.repository.ProdutoRepository;

// Permite o Spring injetar dependências automaticamente
import org.springframework.beans.factory.annotation.Autowired;

// Importa todas as anotações de mapeamento web (Get, Post, Delete...)
import org.springframework.web.bind.annotation.*;

// Importa o tipo List do Java (como um array)
import java.util.List;

// Diz pro Spring que essa classe é um Controller que responde JSON
@CrossOrigin(origins = "http://localhost:5173")
@RestController

// Define a rota base: todas as URLs aqui começam com /produtos
@RequestMapping("/produtos")

    public class ProdutoController {

    // @Autowired pede pro Spring criar e injetar o repository automaticamente
    // Você não precisa fazer "new ProdutoRepository()", o Spring faz isso por você
    @Autowired
    private ProdutoRepository produtoRepository;

    // @GetMapping: responde requisições GET em /produtos
    // Retorna uma lista com todos os produtos do banco
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.findAll(); // Método herdado do JpaRepository
    }

    // @PostMapping: responde requisições POST em /produtos
    // @RequestBody: pega o JSON que veio do front e transforma em objeto Produto
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return produtoRepository.save(produto); // Salva no banco e retorna o produto salvo
    }

    // @DeleteMapping: responde requisições DELETE em /produtos/{id}
    // @PathVariable: pega o {id} que veio na URL
    // Exemplo: DELETE /produtos/3 → deleta o produto de ID 3
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoRepository.deleteById(id); // Deleta pelo ID
    }
}
