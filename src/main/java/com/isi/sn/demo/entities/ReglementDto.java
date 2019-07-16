package com.isi.sn.demo.entities;

public class ReglementDto {

    private String numeroFacture ;
    private int montant ;
    private float taxe ;

    public ReglementDto() {
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public float getTaxe() {
        return taxe;
    }

    public void setTaxe(float taxe) {
        this.taxe = taxe;
    }
}
