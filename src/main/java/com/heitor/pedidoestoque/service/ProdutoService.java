package com.heitor.pedidoestoque.service;

import com.heitor.pedidoestoque.dto.ProdutoRequestDto;
import com.heitor.pedidoestoque.dto.ProdutoResponseDto;
import com.heitor.pedidoestoque.mapper.ProdutoMapper;
import com.heitor.pedidoestoque.model.Produto;
import com.heitor.pedidoestoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    public List<ProdutoResponseDto> findAll() {
        /*
        List<Produto> produtos =  this.produtoRepository.findAll();
        List<ProdutoResponseDto> produtosResponseDto = new ArrayList<>();

        for(Produto produto : produtos) {
            produtosResponseDto.add(produtoMapper.toResponseDto(produto));
        }

        return produtosResponseDto;
         */

        return this.produtoRepository.findAll().stream().map(produtoMapper::toResponseDto).toList();
    }

    public ProdutoResponseDto findById(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));

        return produtoMapper.toResponseDto(produto);
    }

    public ProdutoResponseDto save(ProdutoRequestDto produtoRequestDto) {
        // 1. Converte DTO para Entity
        Produto entity = produtoMapper.toEntity(produtoRequestDto);

        // 2. Salva no banco
        Produto saved = produtoRepository.save(entity);

        // 3. Converte Entity salva para Response DTO e devolve
        return produtoMapper.toResponseDto(saved);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoResponseDto update(Long id, ProdutoRequestDto produtoRequestDto) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
        produto.setNome(produtoRequestDto.nome());
        produto.setDescricao(produtoRequestDto.descricao());
        produto.setPreco(produtoRequestDto.preco());
        produto.setQuantidadeEstoque(produtoRequestDto.quantidadeEstoque());

        Produto produtoAtualizado =  produtoRepository.save(produto);

        return produtoMapper.toResponseDto(produtoAtualizado);
    }
}
