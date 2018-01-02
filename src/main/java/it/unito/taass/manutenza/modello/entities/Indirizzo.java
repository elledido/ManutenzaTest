package it.unito.taass.manutenza.modello.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "Indirizzo.cercaPerId", query = "SELECT o FROM Indirizzo o WHERE o.id = :id"),
    @NamedQuery(name = "Indirizzo.cercaPerProprietario", query = "SELECT o FROM Indirizzo o WHERE o.proprietario.id = :id"),
    @NamedQuery(name = "Indirizzo.cercaIndirizziTutti", query = "SELECT o FROM Indirizzo o")
})
public class Indirizzo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String via;
    private String cap;
    private String citta;
    @ManyToOne
    private Utente proprietario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Utente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Utente proprietario) {
        this.proprietario = proprietario;
    }

}
