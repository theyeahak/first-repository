package com.springstartboot.com.springstartbootRestJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springstartboot.com.springstartbootRestJPA.model.Movie;
import com.springstartboot.com.springstartbootRestJPA.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	MovieRepository repo;
	
/*	public  MovieService(MovieRepository repo) {
		this.repo=repo;
	}*/
	
	
	//read ops of my movies
	public List<Movie> getAllMovie(){
		return repo.findAll();
	}
	//create new movies
	public void addMovie(Movie movie) {
		repo.save(movie);
	}
	//search by my primary key(movie id)
	
	public Movie getMovieById(int Id) {
		
		return repo.findById(Id).get();
	}
	
	public void deleteById(int id) {
		
		Movie m=repo.findById(id).get();
		repo.delete(m);
		
	}
	
	public void updateMovie(Movie mov) {
		repo.save(mov);
		
		
	}
	
	
	
	public List<Movie> getMovieByActressNameAndMovieName(String actressName, String movieName){
		
		List<Movie>movies=repo.findByActressNameAndMovieName(actressName, movieName);
		return movies;
	}
	public List<Movie> getMovieByActressName(String actressname) {
		List<Movie>movies=repo.findByactressName(actressname);
		return movies;
	}	
	
	
//my sortings here---->
	
	public List<Movie> sortbymoviename(){
		List<Movie> moviess=repo.findAll(Sort.by("movieName"));
		return moviess;
		
	}
	
	public List<Movie> sortbyactressname(){
		List<Movie> actresss=repo.findAll(Sort.by("actressName"));
		return actresss;
	}

}
