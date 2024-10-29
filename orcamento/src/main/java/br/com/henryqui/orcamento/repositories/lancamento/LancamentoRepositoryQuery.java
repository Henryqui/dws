package br.com.henryqui.orcamento.repositories.lancamento;

import br.com.henryqui.orcamento.Dto.LancamentoDto;
import br.com.henryqui.orcamento.repositories.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {
    public Page<LancamentoDto> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
}
