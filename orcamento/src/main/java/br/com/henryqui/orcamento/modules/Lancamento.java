package br.com.henryqui.orcamento.modules;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Lancamento")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private LocalDate datalancamento;
    private Long idcliente;
    private String tipolancamento;
    private BigDecimal valorlancamento;

    public long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

    public BigDecimal getValorlancamento() {
        return valorlancamento;
    }

    public void setValorlancamento(BigDecimal valorlancamento) {
        this.valorlancamento = valorlancamento;
    }

    public String getTipolancamento() {
        return tipolancamento;
    }

    public void setTipolancamento(String tipolancamento) {
        this.tipolancamento = tipolancamento;
    }

    public LocalDate getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(LocalDate datalancamento) {
        this.datalancamento = datalancamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lancamento that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

