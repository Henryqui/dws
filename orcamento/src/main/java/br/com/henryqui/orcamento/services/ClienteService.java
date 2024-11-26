package br.com.henryqui.orcamento.services;

import br.com.henryqui.orcamento.model.Cliente;
import br.com.henryqui.orcamento.repositories.ClienteRepository;
import org.hibernate.type.descriptor.sql.internal.CapacityDependentDdlType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
    return clienteRepository.save(cliente);
    }

    public Cliente Atualizar(Integer id, Cliente cliente){
        Cliente clienteSalvo = buscarClienteExistente(id);

        BeanUtils.copyProperties(cliente, clienteSalvo, "id");

        return clienteRepository.save(clienteSalvo);
    }

    private Cliente buscarClienteExistente(Integer id) {
        Optional<Cliente> clienteSalvo = clienteRepository.findById(id);

        if(!clienteSalvo.isPresent()){
            throw new IllegalArgumentException();
        }

        return clienteSalvo.get();
    }
}