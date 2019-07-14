package com.isi.sn.demo.service;

import java.util.List;

import com.isi.sn.demo.entities.*;

public interface Account {
	public User saveUser(User user);
	public Roles saveRole(Roles role);
	public void addRoleToUser(String matricule, String libelle);
	public void rmRoleToUser(String matricule, String libelle);
	public User findByMatricule(String matricule);
	public List<User>allUser();
	public List<Abonnement>getAllAbonnement();
	public List<Client>getAllClient();
	public List<Compteur>getAllCompteur();
	public List<Facture>getAllFacture();
	public List<Reglement>getAllReglement();
	public List<Village> getAllVillage();
	public List<Roles>getAllRole();
	public List<Roles>getAllRoleByMat(String matricule);
	public boolean checkpassword(String matricule, String password);
	public void UpdatePassword(String password, String matricule);
	public String GetMP(String matricule);
	public void activDesactiv(String mat);
	

	
}
