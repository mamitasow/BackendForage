package com.isi.sn.demo.entities;
import javax.persistence.*;
import java.util.List;
import com.isi.sn.demo.entities.Village;
@Entity
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String nomFamille;
    private  String adresse;
    private  String tel;
    private  Boolean estchef;
    @ManyToOne
    private Village village;
    @OneToMany(mappedBy="client",fetch= FetchType.LAZY)
    private List<Abonnement> abonnements;
    @ManyToOne
    @JoinColumn(name="user")
    private User user;
    public Client() { }

    public Client(String nomFamille, String adresse, String tel, Boolean estchef, Village village, List<Abonnement> abonnements, User user) {
        this.nomFamille = nomFamille;
        this.adresse = adresse;
        this.tel = tel;
        this.estchef = estchef;
        this.village = village;
        this.abonnements = abonnements;
        this.user = user;
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

    public Boolean getEstchef() {
        return estchef;
    }

    public void setEstchef(Boolean estchef) {
        this.estchef = estchef;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public List<Abonnement> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(List<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

