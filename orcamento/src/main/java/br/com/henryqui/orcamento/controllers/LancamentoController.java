package br.com.henryqui.orcamento.controllers;

import br.com.henryqui.orcamento.model.Lancamento;
import br.com.henryqui.orcamento.repositories.LancamentoRepository;
import br.com.henryqui.orcamento.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PostMapping()
    public ResponseEntity<Lancamento> inserir(@RequestBody Lancamento lancamento) {

            Lancamento lancamentoSalvo = lancamentoService.salvar(lancamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);

    }

}
