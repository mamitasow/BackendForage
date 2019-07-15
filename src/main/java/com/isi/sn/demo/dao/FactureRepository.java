package com.isi.sn.demo.dao;

import com.isi.sn.demo.entities.Compteur;
import com.isi.sn.demo.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    @Query("select SUM(consnetChiffre)from Facture c where c.id =:id")
    Double FindCumulPrecedent(@Param("id") int id);
}
