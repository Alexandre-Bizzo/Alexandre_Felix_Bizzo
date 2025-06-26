package crud.produtos.service;

import crud.produtos.dto.CategoriaDTO;
import crud.produtos.entry.Categoria;
import crud.produtos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDTO> listar() {
        return categoriaRepository.findAll().stream()
                .map(cat -> new CategoriaDTO(cat.getId(), cat.getNome(), cat.getDescricao()))
                .toList();
    }

    public CategoriaDTO buscarPorId(Long id) {
        Categoria cat = categoriaRepository.findById(id).orElseThrow();
        return new CategoriaDTO(cat.getId(), cat.getNome(), cat.getDescricao());
    }

    public List<CategoriaDTO> buscarPorNome(String nome) {
        return categoriaRepository.findByNomeContainingIgnoreCase(nome).stream()
                .map(cat -> new CategoriaDTO(cat.getId(), cat.getNome(), cat.getDescricao()))
                .toList();
    }

    public CategoriaDTO criar(CategoriaDTO dto) {
        Categoria cat = new Categoria(dto.nome(), dto.descricao());
        cat = categoriaRepository.save(cat);
        return new CategoriaDTO(cat.getId(), cat.getNome(), cat.getDescricao());
    }

    public CategoriaDTO atualizar(Long id, CategoriaDTO dto) {
        Categoria cat = categoriaRepository.findById(id).orElseThrow();
        cat.setNome(dto.nome());
        cat.setDescricao(dto.descricao());
        cat = categoriaRepository.save(cat);
        return new CategoriaDTO(cat.getId(), cat.getNome(), cat.getDescricao());
    }

    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }
}