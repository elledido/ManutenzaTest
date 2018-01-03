package it.unito.taass.manutenza.controllo;

import it.unito.taass.manutenza.modello.business.GestoreUtenteLocal;
import it.unito.taass.manutenza.modello.entities.Indirizzo;
import it.unito.taass.manutenza.modello.entities.Utente;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "utenteController")
@RequestScoped
public class UtenteController {
    
    @Inject
    private GestoreUtenteLocal gestoreUtente;
    private Utente utente = new Utente();
    
    public String doCreaUtente() {
        gestoreUtente.aggiungiUtente(utente);
        FacesContext.getCurrentInstance()
                .addMessage(null, 
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Utente Creato", 
                        "Il nuovo utente " + utente.getNome() + "è stato creato con id: " + utente.getId()));
        return "index.xhtml";
    }
    
    public void getUtentePerId() {
        utente = gestoreUtente.cercaUtentePerId(utente.getId());
    }
    
    public List<Indirizzo> getListaIndirizzi() {
        //if(utente.getListaIndirizzi().isEmpty()) 
            gestoreUtente.caricaListaIndirizzi(utente);
        return utente.getListaIndirizzi();
    }
    
    public void aggiungiIndirizzo(Indirizzo indirizzo) {
        utente.addIndirizzo(indirizzo);
        
    }
    
    public List<Utente> getListaUtenti() {
        return gestoreUtente.cercaUtentiTutti();
    }
   
    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
    
}
