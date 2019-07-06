package com.isi.sn.demo.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    public Roles() {
    }

    public Roles(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name;
    }
}

