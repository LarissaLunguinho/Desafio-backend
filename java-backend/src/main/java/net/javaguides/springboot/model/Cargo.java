package net.javaguides.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cargo") // Nome da tabela no banco de dados
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", nullable = false) // 'nome' não pode ser nulo
    private String nome;

    @Column(name = "descricao", columnDefinition = "TEXT") // 'descricao' pode ser um texto mais longo
    private String descricao;

    public Cargo() {
    }

    public Cargo(String nome, String descricao) {
        super();
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
