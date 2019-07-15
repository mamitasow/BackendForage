package com.isi.sn.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;


import com.isi.sn.demo.dao.*;
import com.isi.sn.demo.entities.*;
import com.isi.sn.demo.service.Account;
import com.isi.sn.demo.service.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/admin")
@CrossOrigin("*")
public class AdminController {
	@Autowired
	private Account account;
	@Autowired
	UserRepository userRepository ;
	@Autowired
	RoleRepository roleRepository ;
	public boolean statut = false;
	@Autowired
	private VillageRepository villageRepository ;
    @Autowired
	ClientRepository clientRepository ;
	@Autowired
	CompteurRepository compteurRepository ;
	@Autowired
	AbonnementRepository abonnementRepository ;
	@Autowired
	FactureRepository factureRepository ;
	@Autowired
	private ParametrageRepository parametrageRepository ;
	@PostMapping("/addUser")
	public User registerForm(@RequestBody UserDto user) {
       User u = new User() ;
       u.setDateNaiss(user.getDateNaiss());
       u.setEnabled(true);
       u.setPrenom(user.getPrenom());
       u.setNom(user.getNom());
       u.setTel(user.getTel());
       System.out.println("=======mat"+user.getMatricule());
       u.setMatricule(user.getMatricule());
       u.setUsername(user.getUsername());
        if(user!=null){
        u=account.saveUser(u);
        String mat = u.getMatricule();
        user.getRoles().forEach(roles -> {
        	account.addRoleToUser(mat, roles.getId());
		});
		}
		return u ;

	}

	@PostMapping("/addUser1")
	public String checkForm(@Valid User user, BindingResult bindingresult, Model model) {
		if (bindingresult.hasErrors()) {

			List<Roles> lroles = account.getAllRole();
			model.addAttribute("Roles", lroles);

			return "ajoutUser";
		}
		user.setPassword("passer");
		user.setEnabled(true);
		account.saveUser(user);
		model.addAttribute("succes", "succes");
		return "ajoutUser";

	}
	@GetMapping("/FindCumulPrecedent/{id}")
	public Double FindCumulPrecedent(@PathVariable("id") int id) {
		return  factureRepository.FindCumulPrecedent(id);
	}

	@GetMapping("/findCompteur/{numeroCompteur}")
	public Compteur findCompteur(@PathVariable("numeroCompteur") String numeroCompteur) {
		return  compteurRepository.findCompteurByNumero(numeroCompteur);
	}
	@PostMapping("/addFacture")
	public Facture addFacture(@RequestBody FactureDto abn) {
		Compteur c;
		Abonnement ab;
		Facture fc = new Facture();
		c=compteurRepository.findCompteurByNumero(abn.getNumerocompteur());
		Double cc=c.getCumulCons()+abn.getCumulCons();
		c.setCumulCons(cc);
		c=compteurRepository.save(c);
		//je veux recuperer la somme des consommations net de la facture concerne ici et faire sa difference avec cc et le returner a input cosommation net
		Double cnet = abn.getCumulCons()-c.getCumulCons();
		//double cp=  factureRepository.FindCumulPrecedent(fc.getId());
		fc.setConsnetChiffre(cnet);
		fc.setConsnetLettre(abn.getConsnetLettre());
		fc.setDateFacture(new Date());
		fc.setMois(abn.getMois());
		ab=abonnementRepository.findAbonnementByCompteur(abn.getNumerocompteur()).get(0);
		Parametrage p = parametrageRepository.findAll().get(0);
		double mnt = cnet*p.getPrixLitres();
		int m =(int)mnt;
		fc.setMontant(m);
	//	ab=abonnementRepository.save(ab);
		fc.setAbonnement(ab);
		fc=factureRepository.save(fc);
		return fc;
	}
	@GetMapping("/findVillage/{nomVillage}")
	public Village findVillage(@PathVariable("nomVillage") String nomVillage) {

		return villageRepository.findVillageByNomvillage(nomVillage);
	}

	@PostMapping("/addAbonnement")
	public Abonnement addAbonnement(@RequestBody AbonnementDto a) {
      Village v ;
      Client c ;
      Compteur cp = new Compteur();
      Abonnement ab = new Abonnement();
      v =  villageRepository.findVillageByNomvillage(a.getNomVillage());
      c = new Client() ;
      c.setAdresse(a.getAdresse());
      c.setNomFamille(a.getNomFamille());
      c.setTel(a.getTel());
      if(a.getEstchef()==1)
      	c.setEstchef(true);

      c=clientRepository.save(c);
      if(v!=null){
      	ab.setClient(c);
	  }else{
      	v = new Village();
      	v.setNomvillage(a.getNomVillage());
      	v.setChef(c);
      	villageRepository.save(v);
	  }
      cp.setNumeroCompteur(cp.getNumeroCompteur());
      cp.setCumulCons((double) 0);
     // cp.setUser();
		cp = compteurRepository.save(cp);
		ab.setClient(c);
		ab.setCompteur(cp);
		ab.setDescription(a.getDescription());
		ab.setNumero(ab.getNumero());
		ab.setDateAbonnement(new Date());

		ab = abonnementRepository.save(ab);
		return ab ;

	}

	@GetMapping("/updateMp")
	public String ChangePasswd(Model model) {

		model.addAttribute("registerForm", new RegisterForm());
		return "ChangePassword";
	}

	@PostMapping("/updateMp")
	public String PasswdChange(@Valid RegisterForm reg, BindingResult bindingresult, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (bindingresult.hasErrors()) {

			return "ChangePassword";
		}
		if (!account.checkpassword(auth.getName(), reg.getAncienMp())) {
			model.addAttribute("erreur", "erreur");
			return "ChangePassword";
		}

		if (!reg.getNouvMp().equals(reg.getConfirMp())) {
			model.addAttribute("erreurConf", "erreur");
			return "ChangePassword";
		}
		account.UpdatePassword(reg.getNouvMp(), auth.getName());
		model.addAttribute("success", "success");
		return "ChangePassword";

	}

	@GetMapping("/listUser")
	public List<User> listeUtilisateur() {

	return userRepository.findAll();

	}

	@GetMapping("/lrole")
	public List<Roles> listeRoles() {

      return roleRepository.findAll();
	}

	@PostMapping("/listUser1")
	public String alllUtilisateur(Model model) {
		return null;

	}
	
	String matricule="";
	
	@GetMapping("/addRole/{mat}")
	public String ajoutRole(Model model, @PathVariable String mat) {
		matricule=mat;
		User u= account.findByMatricule(mat);
	 model.addAttribute("u",u );
	 List<Roles> lroles = new ArrayList<Roles>();

	 for (Roles role : account.getAllRole()) {
		for (Roles role2 : u.getRoles()) {
			if(role.getName()!=role2.getName())
			{
				if(!lroles.contains(role)) {
					lroles.add(role);
				}
			}
		}
		lroles.removeAll(u.getRoles());
	}
	 model.addAttribute("Roles", lroles);
		return "ajoutRole";
	}

	@PostMapping("/addRole")
	public String addRole(User u,Model model) {
		for(Roles role:u.getRoles()) {
			account.addRoleToUser(matricule, role.getId());
		}
		model.addAttribute("succes", "succes");
		return "ajoutRole";

	}

	@GetMapping("/rmRole/{mat}")
	public String removRole(Model model,@PathVariable String mat) {
		matricule=mat;
		User u= account.findByMatricule(mat);
		 model.addAttribute("u",u );
		 List<Roles> lroles = u.getRoles();
		 model.addAttribute("Roles", lroles);
		
		return "removeRole";

	}

	@PostMapping("/rmRole")
	public String removeRole(User u,Model model) {
		System.out.println("Matricule "+matricule);
		System.out.println("role "+u.getRoles());
		for(Roles role:u.getRoles()) {
			account.rmRoleToUser(matricule, role.getName());
		}
		model.addAttribute("succes", "succes");
		return "removeRole";
	}
	@GetMapping("/statut/{mat}")
	public String activDesactiv(Model model,@PathVariable String mat)
	{
		List<User> listeU = account.allUser();
		model.addAttribute("listes", listeU);
		account.activDesactiv(mat);
		model.addAttribute("succes", "succes");
		return "menuAdmin";
		
	}
	

}
