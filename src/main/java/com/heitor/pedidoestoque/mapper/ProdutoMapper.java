package com.heitor.pedidoestoque.mapper;

import com.heitor.pedidoestoque.dto.ProdutoRequestDto;
import com.heitor.pedidoestoque.dto.ProdutoResponseDto;
import com.heitor.pedidoestoque.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    // Converte Request para Entity (para salvar no banco)
    public Produto toEntity(ProdutoRequestDto dto) {
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setQuantidadeEstoque(dto.quantidadeEstoque());

        return produto;
    }

    // Converte Entidade (Model) para Response (DTO)
    public ProdutoResponseDto toResponseDto(Produto produto) {
        return  new ProdutoResponseDto(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getQuantidadeEstoque()
        );
    }
}
