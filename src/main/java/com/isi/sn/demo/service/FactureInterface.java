package com.isi.sn.demo.service;

import com.isi.sn.demo.entities.Compteur;
import com.isi.sn.demo.entities.Facture;
import com.isi.sn.demo.entities.Village;

import java.util.List;

public interface FactureInterface {
    public Compteur findCompteurByNumeroCompteur(String numeroCompteur);
    public Facture addFacture(Facture v);
    public List<Facture> listFacture();
}
