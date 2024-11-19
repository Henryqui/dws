package br.com.henryqui.estoque.services;

import br.com.henryqui.estoque.model.Categoria;
import br.com.henryqui.estoque.repositories.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria Atualizar(Integer id,Categoria categoria) {
        Categoria categoriaSalva = buscarCategoriaExistente(id);

        BeanUtils.copyProperties(categoria, categoriaSalva, "id");

        return categoriaRepository.save(categoriaSalva);
    }

    private Categoria buscarCategoriaExistente(Integer id) {
        Optional<Categoria> categoriaSalva = categoriaRepository.findById(id);

        if(!categoriaSalva.isPresent()){
            throw new IllegalArgumentException();
        }

        return categoriaSalva.get();
    }
}
