package com.isi.sn.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Compteur {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Double setCumulCons(Double cumulCons) {
        this.cumulCons = cumulCons;
        return cumulCons;
    }
    @JsonIgnore
    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }
    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
