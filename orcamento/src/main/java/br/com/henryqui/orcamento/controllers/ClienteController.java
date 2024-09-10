package br.com.henryqui.orcamento.controllers;

import br.com.henryqui.orcamento.model.Cliente;
import br.com.henryqui.orcamento.model.Lancamento;
import br.com.henryqui.orcamento.repositories.ClienteRepository;
import br.com.henryqui.orcamento.repositories.LancamentoRepository;
import br.com.henryqui.orcamento.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping()
    public List<Cliente> listarTodosClientes(){
        return clienteRepository.findAll(Sort.by("nome").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPeloCodigo(@PathVariable int id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()) : ResponseEntity.notFound().build();

    }

    @PostMapping()
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {

        Cliente clienteSalvo = clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable int id){
        clienteRepository.deleteById(id);
    }

}
