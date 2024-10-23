package br.com.henryqui.estoque.repositories.produto;

import br.com.henryqui.estoque.dto.ProdutoDto;
import br.com.henryqui.estoque.model.Produto;
import br.com.henryqui.estoque.repositories.filter.ProdutoFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryImpl implements ProdutoRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<ProdutoDto> filtrar(ProdutoFilter produtoFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ProdutoDto> criteria = builder.createQuery(ProdutoDto.class);
        Root<Produto> root = criteria.from(Produto.class);

        criteria.select(builder.construct(ProdutoDto.class,
                root.get("id"),
                root.get("nomeproduto"),
                root.get("preco"),
                root.get("categoria").get("nome")

        ));

        Predicate[] predicates = criarRestricoes(produtoFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomeproduto")));

        TypedQuery<ProdutoDto> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(),pageable, total(produtoFilter));
    }

    private Long total(ProdutoFilter produtoFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Produto> root = criteria.from(Produto.class);

        Predicate[] predicates = criarRestricoes(produtoFilter, builder, root);
        criteria.where(predicates);

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }


    private void adicionarRestricoesDePaginacao(TypedQuery<ProdutoDto> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Predicate[] criarRestricoes(ProdutoFilter produtoFilter, CriteriaBuilder builder, Root<Produto> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(produtoFilter.getNomeproduto())){
            predicates.add(builder.like(builder.lower(root.get("nomeproduto")),
                    "%" + produtoFilter.getNomeproduto().toLowerCase()+ "%"));
        }

        if (!StringUtils.isEmpty(produtoFilter.getCategoria())){
            predicates.add(builder.like(builder.lower(root.get("categoria").get("nome")),
                    "%" + produtoFilter.getCategoria().toLowerCase()+ "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

}
