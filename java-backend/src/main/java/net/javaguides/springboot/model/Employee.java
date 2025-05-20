package net.javaguides.springboot.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nome")
    private String nome;
    
    @Column(name="email_id")
    private String emailId;

    @Column(name="data_admissao")
    private LocalDate dataAdmissao;

    @Column(name="cargo")
    private String cargo;

    public Employee(){

    }

    public Employee(String nome, LocalDate dataAdmissao, String emailId, String cargo){
        super();
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.emailId = emailId;
        this.cargo = cargo;
    }
    public long getId() {
        return id;
    }
    public void setId (long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }    
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }
    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }    
}
