package com.isi.sn.demo.service;

import java.util.ArrayList;
import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailImpl implements UserDetailsService {
	@Autowired
	private Account account;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.isi.sn.demo.entities.User u=account.findByMatricule(username);
		System.out.println(username);
		if(u==null) {
			throw new UsernameNotFoundException(username);
		}
		Collection<GrantedAuthority>authorities=new ArrayList<GrantedAuthority>();
		u.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getName()));
		});
		return new User(u.getMatricule(),u.getPassword(),authorities);
	}

}
