package org.pizzeria.italy.service;

import java.util.List;

import org.pizzeria.italy.pojo.Appetizer;
import org.pizzeria.italy.repo.AppetizerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppetizerService {

	@Autowired
	private AppetizerRepo appetizerRepo;

	public void save(Appetizer appetizer) {
		appetizerRepo.save(appetizer);
	}

	public List<Appetizer> findAll() {
		return appetizerRepo.findAll();
	}

	public List<Appetizer> findByName(String name) {
		return appetizerRepo.findByNameContainingIgnoreCase(name);
	}

}