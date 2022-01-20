package br.com.rafael.rafamovies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rafael.rafamovies.dto.MovieDTO;
import br.com.rafael.rafamovies.dto.ScoreDTO;
import br.com.rafael.rafamovies.entities.Movies;
import br.com.rafael.rafamovies.entities.Score;
import br.com.rafael.rafamovies.entities.User;
import br.com.rafael.rafamovies.repopsitories.MovieRepository;
import br.com.rafael.rafamovies.repopsitories.ScoreRepository;
import br.com.rafael.rafamovies.repopsitories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO SaveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movies movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);

		double sum = 0.0;
		for(Score s :movie.getScores()){
			sum = sum + s.getValue();
		}
		
		double avg = sum/movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
		
	}
	
	

	

}
