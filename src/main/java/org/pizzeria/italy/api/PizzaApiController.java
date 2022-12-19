package org.pizzeria.italy.api;

import java.util.List;
import org.pizzeria.italy.pojo.Pizza;
import org.pizzeria.italy.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/1/pizza")
@CrossOrigin("*")
public class PizzaApiController {

	@Autowired
	private PizzaService pizzaService;

	@GetMapping("/all")
	public List<Pizza> getAll() {
		
		List<Pizza> allPizzas = pizzaService.findAll();
		return allPizzas ;
	}
	

	
	
	
	
	
	
//	@PostMapping("/create")
//	public Pizza createPizza(@Valid @RequestBody Pizza pizza) {
//
//		System.err.println(pizza);
//
//		Pizza newPizza = pizzaService.save(pizza);
//
//		System.err.println(newPizza);
//
//		return newPizza;
//	}
//
//	@PostMapping("/update/{id}")
//	public Pizza updatePizza(@PathVariable("id") int id, @Valid @RequestBody Pizza pizza) {
//
//		Pizza oldPizza = pizzaService.findPizzaById(id).get();
//		pizza.setIngredients(oldPizza.getIngredients());
//
//		Pizza newPizza = pizzaService.save(pizza);
//
//		return newPizza;
//	}
//
//	@GetMapping("/delete/{id}")
//	public boolean deletePizza(@PathVariable("id") int id) {
//
//		try {
//
//			Pizza pizza = pizzaService.findPizzaById(id).get();
//			pizzaService.deleteById(id);
//		} catch (Exception e) {
//			return false;
//		}
//
//		return true;
//	}
}
