package br.com.henryqui.orcamento.controllers;

import br.com.henryqui.orcamento.model.Lancamento;
import br.com.henryqui.orcamento.model.Municipio;
import br.com.henryqui.orcamento.repositories.LancamentoRepository;
import br.com.henryqui.orcamento.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @GetMapping()
    public List<Lancamento> listarTodosLancamentos(){
        return lancamentoRepository.findAll(Sort.by("tipolancamento").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable int id){
        Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
        return lancamento.isPresent() ? ResponseEntity.ok(lancamento.get()) : ResponseEntity.notFound().build();

    }

    @PostMapping()
    public ResponseEntity<Lancamento> inserir(@RequestBody Lancamento lancamento) {

            Lancamento lancamentoSalvo = lancamentoService.salvar(lancamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable int id){
        lancamentoRepository.deleteById(id);
    }


}
