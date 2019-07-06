package com.isi.sn.demo.entities;
import javax.persistence.*;
import java.util.List;

@Entity
public class Village{
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique=true)
    private String nomvillage;
    @OneToMany(mappedBy="village",fetch= FetchType.LAZY)
    private List<Client> clients;
    @ManyToOne
    @JoinColumn(name="user")
    private User user;

    public Village() {
    }

    public Village(String nomvillage, List<Client> clients, User user) {
        this.nomvillage = nomvillage;
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
        return nomvillage;
    }

    public void setNomvillage(String nomvillage) {
        this.nomvillage = nomvillage;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
