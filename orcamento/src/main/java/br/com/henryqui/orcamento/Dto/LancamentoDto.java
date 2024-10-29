package br.com.henryqui.orcamento.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LancamentoDto {

    private Long id;
    private LocalDate datalancamento;
    private String tipolancamento;
    private BigDecimal valorlancamento;
    private String cliente;


    public LancamentoDto(Long id, LocalDate datalancamento, String tipolancamento, BigDecimal valorlancamento, String cliente) {
        this.id = id;
        this.datalancamento = datalancamento;
        this.tipolancamento = tipolancamento;
        this.valorlancamento = valorlancamento;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(LocalDate datalancamento) {
        this.datalancamento = datalancamento;
    }

    public String getTipolancamento() {
        return tipolancamento;
    }

    public void setTipolancamento(String tipolancamento) {
        this.tipolancamento = tipolancamento;
    }

    public BigDecimal getValorlancamento() {
        return valorlancamento;
    }

    public void setValorlancamento(BigDecimal valorlancamento) {
        this.valorlancamento = valorlancamento;
    }
}
