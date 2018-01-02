package it.unito.taass.manutenza.modello.business;

import it.unito.taass.manutenza.modello.entities.Indirizzo;
import it.unito.taass.manutenza.modello.entities.Utente;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@DataSourceDefinition(
    className = "org.apache.derby.jdbc.EmbeddedDataSource",
    name = "java:global/jdbc/sample",
    user = "app",
    password = "app",
    properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {

    @Inject
    private GestoreUtenteLocal gestoreUtente;
    @Inject
    private GestoreIndirizzoLocal gestoreIndirizzo;
    
    private Utente utente1;
    private Utente utente2;
    
    private Indirizzo indirizzo1;
    private Indirizzo indirizzo2;
    
    @PostConstruct
    private void populateDB() {
        utente1 = new Utente();
        utente1.setNome("Leonardo");
        utente1.setCognome("Di Domenico");
        utente1.setEmail("leonardo.didomenico@edu.unito.it");
        utente1.setPassword("cicci8lemiba19");
        utente1.setAutenticato(false);
        
        utente2 = new Utente();
        utente2.setNome("Rocchina");
        utente2.setCognome("Cericola");
        utente2.setEmail("cericolarocchina@libero.it");
        utente2.setPassword("Arturo41900");
        utente2.setAutenticato(false);
        
        indirizzo1 = new Indirizzo();
        indirizzo1.setVia("Via Berlinguer 28");
        indirizzo1.setCap("71027");
        indirizzo1.setCitta("Orsara di Puglia");
        indirizzo1.setProprietario(utente1);
        
        indirizzo2 = new Indirizzo();
        indirizzo2.setVia("Via del Popolo 1");
        indirizzo2.setCap("71027");
        indirizzo2.setCitta("Orsara di Puglia");
        indirizzo2.setProprietario(utente1);
        
        gestoreUtente.aggiungiUtente(utente1);
        gestoreUtente.aggiungiUtente(utente2);
        
        gestoreIndirizzo.aggiungiIndirizzo(indirizzo1);
        gestoreIndirizzo.aggiungiIndirizzo(indirizzo2);
    }
    
    @PreDestroy
    private void cleanDB() {
        gestoreUtente.rimuoviUtente(utente1);
        gestoreUtente.rimuoviUtente(utente2);    
    }
    
}
