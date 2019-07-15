package com.isi.sn.demo.service;

import com.isi.sn.demo.dao.CompteurRepository;
import com.isi.sn.demo.dao.FactureRepository;
import com.isi.sn.demo.dao.VillageRepository;
import com.isi.sn.demo.entities.Compteur;
import com.isi.sn.demo.entities.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class FactureImpl implements  FactureInterface {
    @Autowired
    private CompteurRepository cdao;
    @Autowired
    private FactureRepository fdao;

    public FactureImpl() {
    }

    @Override
    public Compteur findCompteurByNumeroCompteur(String numeroCompteur) {
        return cdao.findCompteurByNumeroCompteur(numeroCompteur);
    }

    @Override
    public Facture addFacture(Facture v) {
        return fdao.save(v);
    }

    @Override
    public List<Facture> listFacture() {
        return fdao.findAll();
    }
}
