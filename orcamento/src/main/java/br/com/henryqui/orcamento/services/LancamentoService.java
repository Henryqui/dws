package br.com.henryqui.orcamento.services;

import br.com.henryqui.orcamento.model.Lancamento;
import br.com.henryqui.orcamento.repositories.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }
}
