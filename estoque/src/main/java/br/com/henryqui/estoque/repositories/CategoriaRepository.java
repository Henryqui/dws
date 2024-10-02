package br.com.henryqui.estoque.repositories;

import br.com.henryqui.estoque.model.Categoria;
import br.com.henryqui.estoque.repositories.categoria.CategoriaRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>, CategoriaRepositoryQuery {

}
