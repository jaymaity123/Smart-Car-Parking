package com.parking.Park.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.parking.Park.entities.Archon;

public class ArchonServiceImpl extends UserParkServiceImpl {
	
	@Autowired

	@Transactional
	public Archon addNewUser(Archon admin) {
		try {
			admin.setUserType("2");
			if ((admin.getPassword() != null)) {
				String securedPasswordHash = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt(12));
				admin.setPassword(securedPasswordHash);
			}
			userRepository.save(admin);
		} catch (Exception e) {
			log.error("Adding admin exception",e);

		}

		return admin;
	}
	

}
