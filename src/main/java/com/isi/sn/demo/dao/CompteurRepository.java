package com.isi.sn.demo.dao;

import com.isi.sn.demo.entities.Compteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteurRepository extends JpaRepository<Compteur, Long> {
}
