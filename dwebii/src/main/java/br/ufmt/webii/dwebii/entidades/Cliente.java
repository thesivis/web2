package br.ufmt.webii.dwebii.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@SequenceGenerator(name = "seq_cliente",
        sequenceName = "cliente_id_seq", allocationSize = 1)
public class Cliente implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "seq_cliente",
            strategy = GenerationType.SEQUENCE)
    private int id;
    private String nome;
    private String cpf;
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
