package it.unito.taass.manutenza.controllo;

import it.unito.taass.manutenza.modello.business.GestoreIndirizzoLocal;
import it.unito.taass.manutenza.modello.entities.Indirizzo;
import it.unito.taass.manutenza.modello.entities.Utente;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author leonardo
 */
@Named(value = "indirizzoController")
@RequestScoped
public class IndirizzoController {

    @Inject
    private GestoreIndirizzoLocal gestoreIndirizzo;
    
    private Indirizzo indirizzo = new Indirizzo();
    
    public List<Indirizzo> getIndirizziPerUtente(Utente utente) {
        return gestoreIndirizzo.cercaIndirizziPerUtente(utente);
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }
    
    
    
}
