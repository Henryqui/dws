package br.com.henryqui.orcamento.services;

import br.com.henryqui.orcamento.model.Cliente;
import br.com.henryqui.orcamento.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
    return clienteRepository.save(cliente);
    }
}
