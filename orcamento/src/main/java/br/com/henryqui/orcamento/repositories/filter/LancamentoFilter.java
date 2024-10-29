package br.com.henryqui.orcamento.repositories.filter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LancamentoFilter {

    private String tipolancamento;
    private LocalDate datalancamento;
    private BigDecimal valorlancamento;

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

    public BigDecimal getValorlancamento() {
        return valorlancamento;
    }

    public void setValorlancamento(BigDecimal valorlancamento) {
        this.valorlancamento = valorlancamento;
    }
}
