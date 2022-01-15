package br.com.rafael.rafamovies.repopsitories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafael.rafamovies.entities.Movies;

public interface MovieRepository extends JpaRepository<Movies,Long> {

}
