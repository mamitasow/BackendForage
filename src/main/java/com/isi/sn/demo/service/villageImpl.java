package com.isi.sn.demo.service;

import com.isi.sn.demo.dao.VillageRepository;
import com.isi.sn.demo.entities.Village;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class villageImpl implements VillageIterface {
    @Autowired
    private VillageRepository  vdao;
    @Override
    public Village findBynomvillage(String nomvillage) {
        return vdao.findVillageByNomvillage(nomvillage);
    }

    @Override
    public Village addVillage(Village v) {
        return vdao.save(v);
    }

    @Override
    public List<Village> listVillage() {
        return vdao.findAll();
    }
}
