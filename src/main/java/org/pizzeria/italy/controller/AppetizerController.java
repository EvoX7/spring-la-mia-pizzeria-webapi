package org.pizzeria.italy.controller;

import java.util.List;

import org.pizzeria.italy.pojo.Appetizer;
import org.pizzeria.italy.service.AppetizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/appetizer")
@CrossOrigin("*")
public class AppetizerController {

	@Autowired
	private AppetizerService appetizerService;

	@GetMapping("/all")
	public List<Appetizer> getAll() {
		List<Appetizer> appetizers = appetizerService.findAll();
		return appetizers;
	}
}
