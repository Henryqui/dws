package br.com.henryqui.estoque.controllers;

import br.com.henryqui.estoque.model.Categoria;
import br.com.henryqui.estoque.repositories.CategoriaRepository;
import br.com.henryqui.estoque.services.CategoriaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping()
    public List<Categoria> listarTodasCategorias(){
        return categoriaRepository.findAll(Sort.by("nome").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable int id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Categoria> inserir(@RequestBody Categoria categoria) {

        Categoria categoriaSalva = categoriaService.salvar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable int id){
        categoriaRepository.deleteById(id);
    }

}
