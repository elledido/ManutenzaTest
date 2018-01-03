package it.unito.taass.manutenza.modello.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Competenza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo; //amatoriale o professionista
    private String categoria;
    @Column(name = "PARTITA_IVA")
    private String partitaIva;
    @Column(name = "ZONA_COMPETENZA")
    private String zonaCompetenza;
    @ManyToOne
    private Manutente manutente;
    @OneToMany(mappedBy = "competenza", cascade = CascadeType.ALL)
    private List<Richiesta> listaRichieste;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public String getZonaCompetenza() {
        return zonaCompetenza;
    }

    public void setZonaCompetenza(String zonaCompetenza) {
        this.zonaCompetenza = zonaCompetenza;
    }

}
