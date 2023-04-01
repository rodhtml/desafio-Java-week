package com.linuxtips.challengejavaweek.controller;


import com.linuxtips.challengejavaweek.model.Produto;
import com.linuxtips.challengejavaweek.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ProdutoController {

    private ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    };

    private ProdutoService produtoService;

    /*Listar todos os produtos*/
    @GetMapping("/produtos/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listarProdutos(){
        return produtoService.listarProdutos();
    }

    /*Listar produtos pelo ID*/
    @GetMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produto> listarPorId(@PathVariable(value = "id") Long id){
        return produtoService.buscarProdutoPeloId(id);
    }

    /*Atualizar Produto pelo ID*/
    @PutMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> atualizarPorId(@PathVariable(value="id")Long id,@RequestBody Produto produto){
        return produtoService.atualizarProdutoPeloId(produto,id);
    }

    @DeleteMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deletarPorId(@PathVariable(value="id") Long id){
        return produtoService.apagarPeloId(id);
    }
}