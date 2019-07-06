package com.isi.sn.demo.dao;

import com.isi.sn.demo.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}
