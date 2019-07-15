package com.isi.sn.demo.dao;

import com.isi.sn.demo.entities.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
    @Query("Select a from Abonnement a where a.compteur.numeroCompteur =:numC")
    public List<Abonnement> findAbonnementByCompteur(@Param("numC")String numC);
}
