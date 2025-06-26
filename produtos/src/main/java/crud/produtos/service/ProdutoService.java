package crud.produtos.service;

import crud.produtos.dto.ProdutoDTO;
import crud.produtos.entry.Categoria;
import crud.produtos.entry.Produto;
import crud.produtos.repository.CategoriaRepository;
import crud.produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<ProdutoDTO> listar() {
        return produtoRepository.findAll().stream()
                .map(prod -> new ProdutoDTO(prod.getId(), prod.getNome(), prod.getDescricao(), prod.getPreco(),
                        prod.getCategoria().getId()))
                .toList();
    }

    public ProdutoDTO buscarPorId(Long id) {
        Produto prod = produtoRepository.findById(id).orElseThrow();
        return new ProdutoDTO(prod.getId(), prod.getNome(), prod.getDescricao(), prod.getPreco(),
                prod.getCategoria().getId());
    }

    public List<ProdutoDTO> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome).stream()
                .map(prod -> new ProdutoDTO(prod.getId(), prod.getNome(), prod.getDescricao(), prod.getPreco(),
                        prod.getCategoria().getId()))
                .toList();
    }

    public ProdutoDTO criar(ProdutoDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
        Produto produto = new Produto(dto.nome(), dto.descricao(), dto.preco(), categoria);
        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(),
                produto.getCategoria().getId());
    }

    public ProdutoDTO atualizar(Long id, ProdutoDTO dto) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setCategoria(categoria);
        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(),
                produto.getCategoria().getId());
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}