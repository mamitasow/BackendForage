package com.isi.sn.demo.dao;

import com.isi.sn.demo.entities.Compteur;
import com.isi.sn.demo.entities.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompteurRepository extends JpaRepository<Compteur, Long> {

    @Query("select c from Compteur c where c.numeroCompteur =:nc")
    Compteur findCompteurByNumero(@Param("nc") String nc);
}
