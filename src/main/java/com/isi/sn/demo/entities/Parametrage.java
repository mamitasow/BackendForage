package com.isi.sn.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Parametrage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  int prixLitres;
    private  int tauxTaxes;

    public Parametrage() {
    }

    public Parametrage(int prixLitres, int tauxTaxes) {
        this.prixLitres = prixLitres;
        this.tauxTaxes = tauxTaxes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrixLitres() {
        return prixLitres;
    }

    public void setPrixLitres(int prixLitres) {
        this.prixLitres = prixLitres;
    }

    public int getTauxTaxes() {
        return tauxTaxes;
    }

    public void setTauxTaxes(int tauxTaxes) {
        this.tauxTaxes = tauxTaxes;
    }
}
