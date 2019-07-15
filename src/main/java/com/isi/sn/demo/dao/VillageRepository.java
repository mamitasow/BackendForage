package com.isi.sn.demo.dao;

import com.isi.sn.demo.entities.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VillageRepository extends JpaRepository<Village, Long> {


    @Query("select v from Village v where v.nomVillage =:nomv")
    Village findVillageByNomvillage(@Param("nomv") String nomv);

}
