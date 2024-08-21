package br.com.henryqui.orcamento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="cliente")
public class Cliente {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private String numero;
    private String bairro;
    private String telefone;
    private String celular;

    @ManyToOne
    @JoinColumn(name = "idmunicipio")
    private Municipio municipio;


    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Lancamento> lancamentoList = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }


    public long getId() {
        return id;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getBairro() {
        return bairro;
    }

    public String getNumero() {
        return numero;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public List<Lancamento> getLancamentoList() {
        return lancamentoList;
    }

    public void setLancamentoList(List<Lancamento> lancamentoList) {
        this.lancamentoList = lancamentoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
