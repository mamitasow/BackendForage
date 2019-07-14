package com.isi.sn.demo.dao;

import com.isi.sn.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface UserRepository extends JpaRepository<User, Long>{
public boolean findByEnabled(Long id);
public User findByMatricule(String matricule);
@Modifying
@Query("update from User u set u.password=:password  where matricule=:matricule")
public void UpdateUser(@Param("password") String password, @Param("matricule") String matricule);
@Modifying
@Query(value = "update from User u set u.enabled=:enabled  where matricule=:matricule")
public void activDesactiv(@Param("enabled") boolean stat, @Param("matricule") String mat);
}
