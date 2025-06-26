package crud.produtos.entry;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
@Schema(description = "Entidade que representa uma categoria de produtos")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único da categoria", example = "1")
    private Long id;

    @Column(nullable = false, unique = true)
    @Schema(description = "Nome da categoria", example = "Eletrônicos")
    private String nome;

    @Column(length = 255)
    @Schema(description = "Descrição da categoria", example = "Produtos eletrônicos em geral")
    private String descricao;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "Produtos pertencentes a essa categoria")
    private List<Produto> produtos;

    public Categoria() {}

    public Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}