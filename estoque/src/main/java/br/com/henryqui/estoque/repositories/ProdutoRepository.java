package br.com.henryqui.estoque.repositories;


import br.com.henryqui.estoque.model.Produto;
import br.com.henryqui.estoque.repositories.produto.ProdutoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQuery {

}
