package com.isi.sn.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


import com.isi.sn.demo.entities.Roles;
import com.isi.sn.demo.entities.User;
import com.isi.sn.demo.service.Account;
import com.isi.sn.demo.service.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/admin")
@CrossOrigin("*")
public class AdminController {
	@Autowired
	private Account account;
	public boolean statut = false;
	

	
	@PostMapping("/addUser")
	public User registerForm(@RequestBody User  user) {
       User u = null ;
        if(user!=null){
        u=account.saveUser(user);
        String mat = u.getMatricule();
        u.getRoles().forEach(roles -> {
        	account.addRoleToUser(mat, roles.getName());
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
	public String listeUtilisateur(Model model) {

		List<User> listeU = account.allUser();
		model.addAttribute("listes", listeU);
		return "listeUser";

	}

	@PostMapping("/listUser")
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
			account.addRoleToUser(matricule, role.getName());
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
