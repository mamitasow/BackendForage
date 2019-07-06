package com.isi.sn.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDto implements Serializable {
    private Long id;
    private String nom;
    private String prenom;
    private String tel;
    private String username ;
    private Date dateNaiss;
    private String matricule;
    private String password;
    private Boolean enabled;;
    private List<Roles> roles = new ArrayList<Roles>();
    @JsonProperty("roles")
    private void unpackNested(Integer roles[]) {
        for(int i=0;i<roles.length;i++) {
            Roles r = new Roles();
            int id =roles[i];
            System.out.println("Role "+id);
            r.setId(id);
            System.out.println("AppRole "+r.getId());
            this.roles.add(r);
        }
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public UserDto() {
    }

    public UserDto(Long id, String nom, String prenom, String tel, String username, Date dateNaiss, String matricule, String password, Boolean enabled, List<Roles> roles) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.username = username;
        this.dateNaiss = dateNaiss;
        this.matricule = matricule;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }
}
