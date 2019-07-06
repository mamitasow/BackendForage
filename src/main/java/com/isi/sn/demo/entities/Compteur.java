package com.isi.sn.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Compteur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String numeroCompteur;
    private  Double cumulCons;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "compteur", cascade = CascadeType.ALL, optional = false)
    private Abonnement abonnement;
    @ManyToOne
    @JoinColumn(name="user")
    private User user;

    public Compteur() {
    }

    public Compteur(String numeroCompteur, Double cumulCons, Abonnement abonnement, User user) {
        this.numeroCompteur = numeroCompteur;
        this.cumulCons = cumulCons;
        this.abonnement = abonnement;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCompteur() {
        return numeroCompteur;
    }

    public void setNumeroCompteur(String numeroCompteur) {
        this.numeroCompteur = numeroCompteur;
    }

    public Double getCumulCons() {
        return cumulCons;
    }

    public void setCumulCons(Double cumulCons) {
        this.cumulCons = cumulCons;
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
