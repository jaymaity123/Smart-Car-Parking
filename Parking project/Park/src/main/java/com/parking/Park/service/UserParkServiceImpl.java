package com.parking.Park.service;

import org.springframework.stereotype.Service;

import com.parking.Park.entities.UserPark;
import com.parking.Park.exception.InvalidCredentialException;
import com.parking.Park.repository.IUserParkRepository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Service
public class UserParkServiceImpl implements IUserParkService {

	Logger log = LoggerFactory.getLogger(UserParkServiceImpl.class);
	@Autowired
	IUserParkRepository userRepository;
	
	
	@Override
	@Transactional
	public UserPark addNewUser(UserPark user) {
		try {
			if ((user.getPassword() != null)) {
				String securedPasswordHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
				user.setPassword(securedPasswordHash);
			}
			user.setUserType("2");
			userRepository.save(user);
		} catch (Exception e) {
			log.error("Adding user exception",e);

		}

		return user;
	}

	@Override
	public UserPark signIn(UserPark user) throws InvalidCredentialException {
		Optional<UserPark> opt = userRepository.findById(user.getUserId());
		try {
			if (opt.isPresent()) {
				UserPark u = opt.get();
				boolean matched = BCrypt.checkpw(user.getPassword(), u.getPassword());
				if (matched) {
					return u;

				} else {
					throw new InvalidCredentialException("Invalid password");
				}
			} else {
				throw new InvalidCredentialException("Invalid userID");
			}
		} catch (Exception e) {
			throw new InvalidCredentialException("Invalid username or password");
		}
	}

	@Override
	public UserPark signOut(UserPark user) {
		return null;
	}

}
