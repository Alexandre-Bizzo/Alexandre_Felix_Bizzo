package crud.produtos.entry;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "produto")
@Schema(description = "Entidade que representa um produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do produto", example = "10")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Nome do produto", example = "Notebook")
    private String nome;

    @Column(length = 255)
    @Schema(description = "Descrição do produto", example = "Notebook Dell 16GB RAM")
    private String descricao;

    @Column(nullable = false)
    @Schema(description = "Preço do produto", example = "3500.00")
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    @Schema(description = "Categoria do produto")
    private Categoria categoria;

    public Produto() {}

    public Produto(String nome, String descricao, Double preco, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}