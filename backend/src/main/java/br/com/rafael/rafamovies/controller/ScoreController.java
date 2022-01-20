package br.com.rafael.rafamovies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafael.rafamovies.dto.MovieDTO;
import br.com.rafael.rafamovies.dto.ScoreDTO;
import br.com.rafael.rafamovies.services.MovieService;
import br.com.rafael.rafamovies.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	
	@Autowired
	private ScoreService scoreService;
	
	@PutMapping
	public MovieDTO serviceScore(@RequestBody ScoreDTO dto){
		MovieDTO movieDto = scoreService.SaveScore(dto) ;
		return movieDto;
	}

}
