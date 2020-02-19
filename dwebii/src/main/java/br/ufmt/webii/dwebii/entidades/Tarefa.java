package br.ufmt.webii.dwebii.entidades;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tarefa")
@SequenceGenerator(name="seq_tarefa",
        sequenceName="tarefa_id_seq",allocationSize=1)
public class Tarefa {
    
    @Id
    @GeneratedValue(generator="seq_tarefa",
            strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name="descricao")
    private String descricao;
    private boolean finalizado;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_finalizado")
    private Calendar dataFinalizado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Calendar getDataFinalizado() {
        return dataFinalizado;
    }

    public void setDataFinalizado(Calendar dataFinalizado) {
        this.dataFinalizado = dataFinalizado;
    }
    
    
    
}
