package org.pizzeria.italy.service;

import java.util.List;
import java.util.Optional;

import org.pizzeria.italy.pojo.User;
import org.pizzeria.italy.repo.UserRepo;
import org.pizzeria.italy.security.DatabaseUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	public void save(User user) {

		userRepo.save(user);
	}

	public void delete(User user) {

		userRepo.delete(user);
	}

	public Optional<User> findById(int id) {

		return userRepo.findById(id);
	}

	public List<User> findAll() {

		return userRepo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> userOpt = userRepo.findByUsername(username);

		if (userOpt.isEmpty())
			throw new UsernameNotFoundException("User not found");

		return new DatabaseUserDetails(userOpt.get());
	}
}
