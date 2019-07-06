package com.isi.sn.demo.formatter;

import java.text.ParseException;
import java.util.Locale;

import com.isi.sn.demo.dao.RoleRepository;
import com.isi.sn.demo.entities.Roles;

import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service
public class RoleFormatter implements org.springframework.format.Formatter<Roles> {
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public String print(Roles object, Locale locale) {
		
		//return (object!=null ?object.getId().toString():"");
		return null ;
	}

	@Override
	public Roles parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(text);
		return this.roleRepository.findById(id).get();
	}

}
