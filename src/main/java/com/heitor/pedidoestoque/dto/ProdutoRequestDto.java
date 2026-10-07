package com.heitor.pedidoestoque.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoRequestDto(

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        String descricao,

        @NotNull(message = "O preço é obrigatório")
        BigDecimal preco,

        @NotNull(message = "A quantidade é obrigatória")
        Integer quantidadeEstoque
) {}
