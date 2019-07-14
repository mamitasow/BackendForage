package com.isi.sn.demo.service;

import com.isi.sn.demo.entities.Village;

import java.util.List;

public interface VillageIterface {
    public Village findBynomvillage(String nomvillage);
    public Village addVillage(Village v);
    public List<Village> listVillage();
}
