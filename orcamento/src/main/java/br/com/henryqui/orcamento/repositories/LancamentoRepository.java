package br.com.henryqui.orcamento.repositories;

import br.com.henryqui.orcamento.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {
}
