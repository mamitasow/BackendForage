package com.isi.sn.demo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String tel;
    private String username;
    private Date dateNaiss;
    @Column(unique = true)
    private String matricule;
    private String password;
    private Boolean enabled;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Abonnement> abonnements;
    @ManyToMany(cascade={ CascadeType.ALL },fetch = FetchType.EAGER)
    private List<Roles> roles = new ArrayList<>();
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Client> clients;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Compteur> compteurs;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Facture> factures;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Reglement> reglements;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Village> villages;


    public User() {
    }


    public User(String nom, String prenom, String tel, Date dateNaiss, String matricule, String password, Boolean enabled, List<Abonnement> abonnements, List<Roles> roles, List<Client> clients, List<Compteur> compteurs, List<Facture> factures, List<Reglement> reglements, List<Village> villages) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.dateNaiss = dateNaiss;
        this.matricule = matricule;
        this.password = password;
        this.enabled = enabled;
        this.abonnements = abonnements;
        this.roles = roles;
        this.clients = clients;
        this.compteurs = compteurs;
        this.factures = factures;
        this.reglements = reglements;
        this.villages = villages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Abonnement> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(List<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }
    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Compteur> getCompteurs() {
        return compteurs;
    }

    public void setCompteurs(List<Compteur> compteurs) {
        this.compteurs = compteurs;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public List<Reglement> getReglements() {
        return reglements;
    }

    public void setReglements(List<Reglement> reglements) {
        this.reglements = reglements;
    }

    public List<Village> getVillages() {
        return villages;
    }

    public void setVillages(List<Village> villages) {
        this.villages = villages;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
