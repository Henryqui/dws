package br.com.henryqui.estoque.controllers;

import br.com.henryqui.estoque.dto.ProdutoDto;
import br.com.henryqui.estoque.model.Produto;
import br.com.henryqui.estoque.repositories.ProdutoRepository;
import br.com.henryqui.estoque.repositories.filter.ProdutoFilter;
import br.com.henryqui.estoque.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/todos")
    public List<Produto> listarTodosProdutos(){
        return produtoRepository.findAll(Sort.by("nomeproduto").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPeloCodigo(@PathVariable long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.isPresent() ? ResponseEntity.ok(produto.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Produto> inserir(@RequestBody Produto produto){

        Produto produtoSalvo = produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }


    public Page<ProdutoDto> pesquisar(ProdutoFilter produtoFilter, Pageable pageable){
        return produtoRepository.filtrar(produtoFilter, pageable);
    }

}