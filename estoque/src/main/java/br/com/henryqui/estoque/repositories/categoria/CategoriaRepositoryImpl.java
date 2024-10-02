package br.com.henryqui.estoque.repositories.categoria;

import br.com.henryqui.estoque.model.Categoria;
import br.com.henryqui.estoque.repositories.filter.CategoriaFilter;
import ch.qos.logback.core.util.StringUtil;
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

public class CategoriaRepositoryImpl implements CategoriaRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;
    @Override
    public Page<Categoria> filtrar(CategoriaFilter categoriaFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
        Root<Categoria> root = criteria.from(Categoria.class);

        Predicate[] predicates = criarRestricoes(categoriaFilter,builder,root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nome")));

        TypedQuery<Categoria> query = manager.createQuery(criteria);
        adicionarRestricoesPaginacao(query, pageable);
        return new PageImpl<>(query.getResultList(), pageable, total(categoriaFilter));
    }

    private Long total(CategoriaFilter categoriaFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Categoria> root = criteria.from(Categoria.class);

        Predicate[] predicates = criarRestricoes(categoriaFilter,builder,root);
        criteria.where(predicates);

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricoesPaginacao(TypedQuery<Categoria> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Predicate[] criarRestricoes(CategoriaFilter categoriaFilter, CriteriaBuilder builder, Root<Categoria> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(categoriaFilter.getNome())){
            predicates.add(builder.like(builder.lower(root.get("nome")),
                    "%" + categoriaFilter.getNome().toLowerCase()+ "%"));
        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
