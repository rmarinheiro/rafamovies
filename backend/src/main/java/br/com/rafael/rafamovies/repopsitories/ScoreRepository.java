package br.com.rafael.rafamovies.repopsitories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafael.rafamovies.entities.Movies;
import br.com.rafael.rafamovies.entities.Score;
import br.com.rafael.rafamovies.entities.ScorePK;
import br.com.rafael.rafamovies.entities.User;

public interface ScoreRepository extends JpaRepository<Score,ScorePK> {

}
