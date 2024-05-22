package br.com.henryqui.orcamento.modules;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="Cliente")
public class Cliente {


    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String endereco;
    private String numero;
    private String bairro;
    private int id_municipio;
    private String telefone;
    private String celular;

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }


    public long getId() {
        return id;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
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

    public int getId_municipio() {
        return id_municipio;
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
