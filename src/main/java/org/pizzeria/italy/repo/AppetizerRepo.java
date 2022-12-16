package org.pizzeria.italy.repo;

import java.util.List;

import org.pizzeria.italy.pojo.Appetizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppetizerRepo extends JpaRepository<Appetizer, Integer> {

	List<Appetizer> findByNameContainingIgnoreCase(String name);

}
