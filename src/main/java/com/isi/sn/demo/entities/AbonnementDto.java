package com.isi.sn.demo.entities;

public class AbonnementDto {
    private Long id ;
    private  String nomFamille;
    private  String adresse;
    private  String tel;
    private  int estchef;
    private  String description;
    private String nomVillage ;
    public AbonnementDto() {
    }

    public String getNomVillage() {
        return nomVillage;
    }

    public void setNomVillage(String nomVillage) {
        this.nomVillage = nomVillage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomFamille() {
        return nomFamille;
    }

    public void setNomFamille(String nomFamille) {
        this.nomFamille = nomFamille;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getEstchef() {
        return estchef;
    }

    public void setEstchef(int estchef) {
        this.estchef = estchef;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
