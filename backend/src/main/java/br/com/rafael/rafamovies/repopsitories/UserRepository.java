package br.com.rafael.rafamovies.repopsitories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafael.rafamovies.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	User findByEmail(String email);

}
