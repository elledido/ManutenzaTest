package it.unito.taass.manutenza.modello.business;

import it.unito.taass.manutenza.modello.entities.Utente;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GestoreUtenteLocal {
    
    public void aggiungiUtente(Utente utente);
    public Utente cercaUtentePerId(Long id);
    public Utente cercaUtentePerEmail(String email);
    public List<Utente> cercaUtentiTutti();
    public void rimuoviUtente(Utente utente);
    public void verifica(String password, String email);
    public void caricaListaIndirizzi(Utente utente);
    
}
