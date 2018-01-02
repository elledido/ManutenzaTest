package it.unito.taass.manutenza.modello.business;

import it.unito.taass.manutenza.modello.entities.Indirizzo;
import it.unito.taass.manutenza.modello.entities.Utente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GestoreUtente implements GestoreUtenteLocal {
    
    @PersistenceContext(unitName = "manutenzaPU")
    private EntityManager em;
    
    @Override
    public void aggiungiUtente(Utente utente) {
        String hashedPassword = md5hash(utente.getPassword());
        utente.setPassword(hashedPassword);
        em.persist(utente);
    }

    @Override
    public Utente cercaUtentePerId(Long id) {
        Utente utente = em.createNamedQuery("Utente.cercaPerId", Utente.class)
              .setParameter("id", id)
              .getSingleResult();
        return utente;
        //return em.find(Utente.class, id);
    }
    
    @Override
    public Utente cercaUtentePerEmail(String email) {
       Utente utente = em.createNamedQuery("Utente.cercaPerEmail", Utente.class)
                .setParameter("email", email)
                .getSingleResult();
       return utente;
    }

    @Override
    public List<Utente> cercaUtentiTutti() {
        List<Utente> listaUtenti = em.createNamedQuery("Utente.cercaTutti", Utente.class)
                .getResultList();
        return listaUtenti;
    }

    @Override
    public void rimuoviUtente(Utente utente) {
       em.remove(utente);
    }
    
    @Override
    public void caricaListaIndirizzi(Utente utente) {
        //List<Indirizzo> listaIndirizzi = gestoreIndirizzo.cercaIndirizziPerUtente(utente);
        List<Indirizzo> listaIndirizzi = 
                em.createNamedQuery("Utente.cercaIndirizzi", Indirizzo.class)
                .setParameter("id", utente.getId())
                .getResultList();
        utente.setListaIndirizzi(listaIndirizzi);
    }
    
    @Override
    public void verifica(String password, String email) {
        Utente utente = cercaUtentePerEmail(email);
        String hashedPassword = md5hash(password);
        if(hashedPassword.equals(utente.getPassword())) {
            utente.setAutenticato(true);
        } else {
            utente.setAutenticato(false);
        }
    }
    
    private String md5hash(String password) {
        String hashString = null;
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(password.getBytes());
            hashString = "";
            for (int i = 0; i < hash.length; i++) {
                hashString += Integer.toHexString(
                                  (hash[i] & 0xFF) | 0x100
                              ).toLowerCase().substring(1,3);
            }
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("Si è verificato un errore" + e.getMessage());
        }
        return hashString;
    }
    
}
