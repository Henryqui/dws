package br.com.henryqui.orcamento.controllers;

import br.com.henryqui.orcamento.model.Lancamento;
import br.com.henryqui.orcamento.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;


    @PostMapping()
    public ResponseEntity<Lancamento> inserir(@RequestBody Lancamento lancamento) {

            Lancamento lancamentoSalvo = lancamentoService.salvar(lancamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);

    }

}
