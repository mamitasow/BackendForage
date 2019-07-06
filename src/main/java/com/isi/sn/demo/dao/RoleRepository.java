package com.isi.sn.demo.dao;

import com.isi.sn.demo.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
	public Roles findByName(String name);
}
