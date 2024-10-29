package br.com.henryqui.orcamento.repositories.cliente;

import br.com.henryqui.orcamento.Dto.LancamentoDto;
import br.com.henryqui.orcamento.repositories.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery{
    @Override
    public Page<LancamentoDto> filtrar(ClienteFilter clienteFilter, Pageable pageable) {
        return null;
    }
}
