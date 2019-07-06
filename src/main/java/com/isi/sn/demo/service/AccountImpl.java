package com.isi.sn.demo.service;

import java.util.Date;
import java.util.List;

import com.isi.sn.demo.dao.*;
import com.isi.sn.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class AccountImpl implements Account{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AbonnementRepository abonnementRepository;
	@Autowired
	private ClientRepository clientRepositoryRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private CompteurRepository  compteurRepository;
	@Autowired
	private FactureRepository  factureRepository;
	@Autowired
	private ReglementRepository reglementRepository;
	@Autowired
	private VillageRepository villageRepository;

	@Override
	public User saveUser(User user) {
		String mpass=bCryptPasswordEncoder.encode("passer");
		user.setPassword(mpass);
		user.setDateNaiss(new Date());
		return userRepository.save(user);
	}

	@Override
	public Roles saveRole(Roles role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String matricule, String libelle) {
		User user=userRepository.findByMatricule(matricule);
		Roles role=roleRepository.findByName(libelle);
		user.getRoles().add(role);
	}

	@Override
	public void rmRoleToUser(String matricule, String libelle) {
		User user=userRepository.findByMatricule(matricule);
		Roles role=roleRepository.findByName(libelle);
		user.getRoles().remove(role);
	}

	@Override
	public User findByMatricule(String matricule) {
		return userRepository.findByMatricule(matricule);
	}

	@Override
	public List<User> allUser() {
		return userRepository.findAll();
	}

	@Override
	public List<Abonnement> getAllAbonnement() {
		return abonnementRepository.findAll();
	}

	@Override
	public List<Client> getAllClient() {
		return clientRepositoryRepository.findAll();
	}

	@Override
	public List<Compteur> getAllCompteur() {
		return  compteurRepository.findAll();
	}

	@Override
	public List<Facture> getAllFacture() {
		return factureRepository.findAll();
	}

	@Override
	public List<Reglement> getAllReglement() {
		return reglementRepository.findAll();
	}

	@Override
	public List<Village> getAllVillage() {
		return villageRepository.findAll();
	}

	@Override
	public List<Roles> getAllRole() {
		return roleRepository.findAll();
	}

	@Override
	public List<Roles> getAllRoleByMat(String matricule) {
		return null;
	}

	@Override
	public boolean checkpassword(String matricule, String password) {
		User u= userRepository.findByMatricule(matricule);
		if(bCryptPasswordEncoder.matches(password, u.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public void UpdatePassword(String password, String matricule) {
		String mpass=bCryptPasswordEncoder.encode(password);
		userRepository.UpdateUser(mpass,matricule);
	}

	@Override
	public String GetMP(String matricule) {
		User u= userRepository.findByMatricule(matricule);
		return u.getPassword();
	}

	@Override
	public void activDesactiv(String mat) {
		User u=userRepository.findByMatricule(mat);
		if(u.getEnabled()==true)
		{
			userRepository.activDesactiv(false, mat);
		}
		else {
			userRepository.activDesactiv(true, mat);
		}
	}
}
