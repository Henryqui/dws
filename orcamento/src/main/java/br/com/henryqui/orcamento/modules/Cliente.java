package br.com.henryqui.orcamento.modules;

import jakarta.persistence.*;

@Entity
@Table("Cliente")
public class Cliente {


    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;

    private String nome;

}
