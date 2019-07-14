package com.isi.sn.demo.dao;

import com.isi.sn.demo.entities.Village;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VillageRepository extends JpaRepository<Village, Long> {
    public Village findBynomvillage(String nomvillage);
}
