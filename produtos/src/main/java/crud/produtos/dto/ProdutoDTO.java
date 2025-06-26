package crud.produtos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;

public record ProdutoDTO(
    Long id,

    @NotBlank(message = "O nome do produto é obrigatório")
    @Size(max = 100, message = "O nome do produto deve ter no máximo 100 caracteres")
    String nome,

    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    String descricao,

    @NotNull(message = "O preço do produto é obrigatório")
    @Positive(message = "O preço deve ser positivo")
    Double preco,

    @NotNull(message = "O ID da categoria é obrigatório")
    Long categoriaId
) {}