package it.unito.taass.manutenza.modello.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Richiesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titolo;
    private String descrizione;
    private String categoria;
    private double budget;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "DATA_CREAZIONE")
    private Date dataCreazione;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "DATA_COMPLETAMENTO")
    private Date dataCompletamento;
    @Column(name = "STATO_COMPLETAMENTO")
    private String statoCompletamento;
    @ManyToOne
    private Competenza competenza;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Date getDataCompletamento() {
        return dataCompletamento;
    }

    public void setDataCompletamento(Date dataCompletamento) {
        this.dataCompletamento = dataCompletamento;
    }

    public String getStatoCompletamento() {
        return statoCompletamento;
    }

    public void setStatoCompletamento(String statoCompletamento) {
        this.statoCompletamento = statoCompletamento;
    }

    public Competenza getCompetenza() {
        return competenza;
    }

    public void setCompetenza(Competenza competenza) {
        this.competenza = competenza;
    }

}
