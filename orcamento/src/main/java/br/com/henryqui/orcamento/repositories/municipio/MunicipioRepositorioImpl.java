package br.com.henryqui.orcamento.repositories.municipio;

import br.com.henryqui.orcamento.model.Municipio;
import br.com.henryqui.orcamento.repositories.filter.MunicipioFilter;
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

public class MunicipioRepositorioImpl implements MunicipioRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @PersistenceContext
    @Override
    public Page<Municipio> filtrar(MunicipioFilter municipioFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Municipio> criteria = builder.createQuery(Municipio.class);
        Root<Municipio> root = criteria.from(Municipio.class);

        Predicate[] predicates = criarRestricoes(municipioFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nome")), builder.asc(root.get("estado")));

        TypedQuery<Municipio> query = manager.createQuery(criteria);
        adicionarRestricaoPaginacao(query, pageable);
        return new PageImpl<>(query.getResultList(), pageable, total(municipioFilter));
    }

    private long total(MunicipioFilter municipioFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Municipio> root = criteria.from(Municipio.class);

        Predicate[] predicates = criarRestricoes(municipioFilter, builder, root);
        criteria.where(predicates);

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricaoPaginacao(TypedQuery<Municipio> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorSize = pageable.getPageSize();
        int primeiroRegistroPagina = paginaAtual * totalRegistrosPorSize;

        query.setFirstResult(primeiroRegistroPagina);
        query.setMaxResults(totalRegistrosPorSize);
    }

    private Predicate[] criarRestricoes(MunicipioFilter municipioFilter, CriteriaBuilder builder, Root<Municipio> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(municipioFilter.getNome())){
            predicates.add(builder.like(builder.lower(root.get("nome")), builder.like(builder.lower(root.get("estado")),
                    "%" + municipioFilter.getNome().toLowerCase() + "%")));
        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
