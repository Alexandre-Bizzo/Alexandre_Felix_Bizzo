package crud.produtos.controller;

import crud.produtos.dto.CategoriaDTO;
import crud.produtos.service.CategoriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@Tag(name = "Categoria", description = "Endpoints para categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<CategoriaDTO> listar() {
        return categoriaService.listar();
    }

    @GetMapping("/{id}")
    public CategoriaDTO buscarPorId(@PathVariable Long id) {
        return categoriaService.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<CategoriaDTO> buscarPorNome(@RequestParam String nome) {
        return categoriaService.buscarPorNome(nome);
    }

    @PostMapping
    public CategoriaDTO criar(@RequestBody @Valid CategoriaDTO dto) {
        return categoriaService.criar(dto);
    }

    @PutMapping("/{id}")
    public CategoriaDTO atualizar(@PathVariable Long id, @RequestBody @Valid CategoriaDTO dto) {
        return categoriaService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
    }
}