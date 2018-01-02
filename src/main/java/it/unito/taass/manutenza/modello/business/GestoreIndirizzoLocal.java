package it.unito.taass.manutenza.modello.business;

import it.unito.taass.manutenza.modello.entities.Indirizzo;
import it.unito.taass.manutenza.modello.entities.Utente;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GestoreIndirizzoLocal {
    
    public void aggiungiIndirizzo(Indirizzo indirizzo);
    public void rimuoviIndirizzo(Indirizzo indirizzo);
    public Indirizzo cercaIndirizzoPerId(Long id);
    public List<Indirizzo> cercaIndirizziPerUtente(Utente utente);
    public List<Indirizzo> cercaIndirizziTutti();
    
}
