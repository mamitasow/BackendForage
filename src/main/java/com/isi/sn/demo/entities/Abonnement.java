package com.isi.sn.demo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Temporal(TemporalType.DATE)
    private Date dateAbonnement;
    private  String numero;
    private  String description;
    @ManyToOne
    @JoinColumn(name="code_client")
    private Client client;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compteur_id")
    private Compteur compteur;
    @OneToMany(mappedBy="abonnement",fetch= FetchType.LAZY)
    private List<Facture> factures;
    @ManyToOne
    @JoinColumn(name="user")
    private User user;

    public Abonnement() {
    }

    public Abonnement(Date dateAbonnement, String numero, String description, Client client, Compteur compteur, List<Facture> factures, User user) {
        this.dateAbonnement = dateAbonnement;
        this.numero = numero;
        this.description = description;
        this.client = client;
        this.compteur = compteur;
        this.factures = factures;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateAbonnement() {
        return dateAbonnement;
    }

    public void setDateAbonnement(Date dateAbonnement) {
        this.dateAbonnement = dateAbonnement;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Compteur getCompteur() {
        return compteur;
    }

    public void setCompteur(Compteur compteur) {
        this.compteur = compteur;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
