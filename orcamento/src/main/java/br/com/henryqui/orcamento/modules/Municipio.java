package br.com.henryqui.orcamento.modules;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="Municipio")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Municipio municipio)) return false;
        return id == municipio.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
