package it.unito.taass.manutenza.modello.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MANUTENTE")
public class Manutente extends Utente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "VALUTAZIONE_COMPLESSIVA")
    private int valutazioneComplessiva;
    @OneToMany(mappedBy = "manutente", cascade = CascadeType.ALL)
    private List<Competenza> listaCompetenze;
    

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getValutazioneComplessiva() {
        return valutazioneComplessiva;
    }

    public void setValutazioneComplessiva(int valutazioneComplessiva) {
        this.valutazioneComplessiva = valutazioneComplessiva;
    }
    
    public void addCompetenza(Competenza competenza) {
        this.listaCompetenze.add(competenza);
    }
    
    public List<Competenza> getListaCompetenze() {
        return this.listaCompetenze;
    }

}
