package it.unito.taass.manutenza.modello.business;

import it.unito.taass.manutenza.modello.entities.Indirizzo;
import it.unito.taass.manutenza.modello.entities.Utente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@Stateless
public class GestoreIndirizzo implements GestoreIndirizzoLocal {
    
    @PersistenceContext(unitName = "manutenzaPU")
    private EntityManager em;

    @Override
    public void aggiungiIndirizzo(Indirizzo indirizzo) {
         em.persist(indirizzo);
    }

    @Override
    public void rimuoviIndirizzo(Indirizzo indirizzo) {
        em.remove(indirizzo);
    }

    @Override
    public Indirizzo cercaIndirizzoPerId(Long id) {
        Indirizzo indirizzo = em.createNamedQuery("Indirizzo.cercaPerId", Indirizzo.class)
                .setParameter("id", id)
                .getSingleResult();
        return indirizzo;
    }

    @Override
    public List<Indirizzo> cercaIndirizziPerUtente(Utente utente) {
        Long idUtente = utente.getId();
        List<Indirizzo> listaIndirizzi = em.createNamedQuery("Indirizzo.cercaPerProprietario", Indirizzo.class)
                .setParameter("id", idUtente)
                .getResultList();
        return listaIndirizzi;
    }

    @Override
    public List<Indirizzo> cercaIndirizziTutti() {
        List<Indirizzo> listaIndirizzi = em.createNamedQuery("Indirizzo.cercaIndirizziTutti", Indirizzo.class)
                .getResultList();
        return listaIndirizzi;
    }

    
    
}
