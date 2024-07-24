package br.com.henryqui.orcamento.repositories;

import br.com.henryqui.orcamento.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {
}
