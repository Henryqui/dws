package br.com.henryqui.orcamento.repositories.cliente;

import br.com.henryqui.orcamento.Dto.ClienteDto;
import br.com.henryqui.orcamento.Dto.LancamentoDto;
import br.com.henryqui.orcamento.repositories.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
    public Page<ClienteDto> filtrar(ClienteFilter clienteFilter, Pageable pageable);
}
