package com.isi.sn.demo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class Reglement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String consnetLettre;
    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    @ManyToOne
    @JoinColumn(name="code_facture")
    private Facture facture;
    @ManyToOne
    @JoinColumn(name="user")
    private User user;


    public Reglement() {
    }


    public Reglement(String consnetLettre, Date dateFacture, Facture facture, User user) {
        this.consnetLettre = consnetLettre;
        this.dateFacture = dateFacture;
        this.facture = facture;
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

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
