package com.isi.sn.demo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Village{
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique=true)
    private String nomVillage;
    @OneToMany(mappedBy="village",fetch= FetchType.LAZY)
    private List<Client> clients;
    @ManyToOne
    @JoinColumn(name="user")
    private User user;
    @ManyToOne
    @JoinColumn(name="chef")
    private Client chef;

    public Village() {
    }
    @JsonIgnore
    public Client getChef() {
        return chef;
    }

    public void setChef(Client chef) {
        this.chef = chef;
    }

    public Village(String nomVillage, List<Client> clients, User user) {
        this.nomVillage = nomVillage;
        this.clients = clients;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomvillage() {
        return nomVillage;
    }

    public void setNomvillage(String nomvillage) {
        this.nomVillage = nomvillage;
    }
    @JsonIgnore
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
