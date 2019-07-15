package com.isi.sn.demo.entities;

public class FactureDto {
    private Long id ;
    private  String consnetLettre;
    private  int mois;
    private  int montant;
    private  float consnetChiffre;
    private  double cumulCons;
    private String numerocompteur;
    private int prixLitres;
    public FactureDto() {
    }

    public int getPrixLitres() {
        return prixLitres;
    }

    public void setPrixLitres(int prixLitres) {
        this.prixLitres = prixLitres;
    }

    public String getNumerocompteur() {
        return numerocompteur;
    }

    public void setNumerocompteur(String numerocompteur) {
        this.numerocompteur = numerocompteur;
    }

    public Double getCumulCons() {
        return cumulCons;
    }

    public void setCumulCons(Double cumulCons) {
        this.cumulCons = cumulCons;
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

    public float getConsnetChiffre() {
        return consnetChiffre;
    }

    public void setConsnetChiffre(float consnetChiffre) {
        this.consnetChiffre = consnetChiffre;
    }
}
