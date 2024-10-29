package br.com.henryqui.orcamento.Dto;

public class ClienteDto {
    private Long id;
    private String nome;
    private String endereco;
    private String numero;
    private String bairro;
    private String telefone;
    private String celular;
    private String municipio;

    public ClienteDto(Long id, String nome, String endereco, String numero, String bairro, String telefone, String celular, String municipio) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.telefone = telefone;
        this.celular = celular;
        this.municipio = municipio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
