package br.com.henryqui.orcamento.services;

import br.com.henryqui.orcamento.model.Lancamento;
import br.com.henryqui.orcamento.repositories.LancamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }

    public Lancamento Atualizar(Integer id, Lancamento lancamento){
        Lancamento lancamentoSalvo = buscarLancamentoExistente(id);

        BeanUtils.copyProperties(lancamento, lancamentoSalvo, "id");

        return lancamentoRepository.save(lancamentoSalvo);
    }

    private Lancamento buscarLancamentoExistente(Integer id) {
        Optional<Lancamento> lancamentoSalvo = lancamentoRepository.findById(id);

        if (!lancamentoSalvo.isPresent()) {
            throw new IllegalArgumentException();
        }
        return lancamentoSalvo.get();
    }
}
