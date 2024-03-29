package com.isi.sn.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String consnetLettre;
    private  double consnetChiffre;
    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    private  int mois;
    private int montant;
    private String numeroFacture ;
    @ManyToOne
    @JoinColumn(name="codeAbonnement")
    private Abonnement abonnement;
    @ManyToOne
    @JoinColumn(name="user")
    private User user;

    public Facture() { }

    public Facture(String consnetLettre, int consnetChiffre, Date dateFacture, int mois, int montant, Abonnement abonnement, User user) {
        this.consnetLettre = consnetLettre;
        this.consnetChiffre = consnetChiffre;
        this.dateFacture = dateFacture;
        this.mois = mois;
        this.montant = montant;
        this.abonnement = abonnement;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConsnetLettre() {
        return consnetLettre;
    }

    public void setConsnetLettre(String consnetLettre) {
        this.consnetLettre = consnetLettre;
    }

    public double getConsnetChiffre() {
        return consnetChiffre;
    }

    public void setConsnetChiffre(double consnetChiffre) {
        this.consnetChiffre = consnetChiffre;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
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

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }
}
