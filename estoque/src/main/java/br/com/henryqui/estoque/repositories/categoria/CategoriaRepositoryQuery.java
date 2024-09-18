package br.com.henryqui.estoque.repositories.categoria;

import br.com.henryqui.estoque.model.Categoria;
import br.com.henryqui.estoque.repositories.filter.CategoriaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoriaRepositoryQuery {
    public Page<Categoria> filtrar(CategoriaFilter categoriaFilter, Pageable pageable);
}
