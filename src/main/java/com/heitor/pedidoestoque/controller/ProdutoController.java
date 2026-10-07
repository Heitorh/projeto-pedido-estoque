package com.heitor.pedidoestoque.controller;

import com.heitor.pedidoestoque.dto.ProdutoRequestDto;
import com.heitor.pedidoestoque.dto.ProdutoResponseDto;
import com.heitor.pedidoestoque.mapper.ProdutoMapper;
import com.heitor.pedidoestoque.model.Produto;
import com.heitor.pedidoestoque.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Listar todos os produtos
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> getAllProdutos() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    // Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> getProdutoById(@PathVariable Long id) {
         return ResponseEntity.ok(produtoService.findById(id));
    }

    // Criar um novo produto
    @PostMapping
    public ResponseEntity<ProdutoResponseDto> createProduto(@Valid @RequestBody ProdutoRequestDto produtoRequestDto) {
        ProdutoResponseDto produtoSalvo = produtoService.save(produtoRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    // Atualizar um produto existente
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> updateProduto(@PathVariable Long id, @RequestBody ProdutoRequestDto produtoRequestDto) {
        ProdutoResponseDto produtoResponseDto = produtoService.update(id, produtoRequestDto);
        return ResponseEntity.ok(produtoResponseDto);
    }

    // Deletar um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
