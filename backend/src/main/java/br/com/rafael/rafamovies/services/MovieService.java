package br.com.rafael.rafamovies.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rafael.rafamovies.dto.MovieDTO;
import br.com.rafael.rafamovies.entities.Movies;
import br.com.rafael.rafamovies.repopsitories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Transactional(readOnly =  true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movies> movies = movieRepository.findAll(pageable);
		Page<MovieDTO> page = movies.map(x->new MovieDTO(x));
		return page;
	}
	
	public MovieDTO findById(Long id) {
		Movies movies = movieRepository.findById(id).get();
		MovieDTO dto = new MovieDTO(movies);
		return dto;
	}

}
