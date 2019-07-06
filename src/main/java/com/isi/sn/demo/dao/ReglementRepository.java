package com.isi.sn.demo.dao;

import com.isi.sn.demo.entities.Reglement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReglementRepository extends JpaRepository<Reglement, Long> {
}
