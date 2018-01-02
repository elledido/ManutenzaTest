package it.unito.taass.manutenza.modello.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "Utente.cercaPerEmail", query = "SELECT u FROM Utente u WHERE u.email = :email"),
    @NamedQuery(name = "Utente.cercaTutti", query = "SELECT u FROM Utente u"),
    @NamedQuery(name = "Utente.cercaPerId", query = "SELECT u FROM Utente u WHERE u.id = :id"),
    @NamedQuery(name = "Utente.cercaIndirizzi", query = "SELECT i FROM Indirizzo i JOIN i.proprietario u WHERE u.id = :id")
})
public class Utente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cognome;
    @Column(unique = true)
    private String email;
    private String password;
    @Column
    private boolean autenticato;
    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL)
    private List<Indirizzo> listaIndirizzi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isAutenticato() {
        return this.autenticato;
    }

    public void setAutenticato(boolean autenticato) {
        this.autenticato = autenticato;
    }
    
    public List<Indirizzo> getListaIndirizzi() {
        return listaIndirizzi;
    }

    public void setListaIndirizzi(List<Indirizzo> listaIndirizzi) {
        this.listaIndirizzi = listaIndirizzi;
    }

}
