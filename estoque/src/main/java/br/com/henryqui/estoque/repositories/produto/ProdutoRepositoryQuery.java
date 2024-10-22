package br.com.henryqui.estoque.repositories.produto;
import br.com.henryqui.estoque.dto.ProdutoDto;
import br.com.henryqui.estoque.repositories.filter.ProdutoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoRepositoryQuery {
    public Page<ProdutoDto> filtrar(ProdutoFilter produtoFilter, Pageable pageable);
}
