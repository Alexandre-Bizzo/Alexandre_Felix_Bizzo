package crud.produtos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoriaDTO(
    Long id,

    @NotBlank(message = "O nome da categoria é obrigatório")
    @Size(max = 100, message = "O nome da categoria deve ter no máximo 100 caracteres")
    String nome,

    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    String descricao
) {}