package com.heitor.pedidoestoque.dto;

import java.math.BigDecimal;

public record ProdutoResponseDto(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        Integer quantidadeEstoque
) {}
