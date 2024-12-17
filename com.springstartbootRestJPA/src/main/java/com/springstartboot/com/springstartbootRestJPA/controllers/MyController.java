package com.springstartboot.com.springstartbootRestJPA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springstartboot.com.springstartbootRestJPA.client.Client;
import com.springstartboot.com.springstartbootRestJPA.model.Movie;
import com.springstartboot.com.springstartbootRestJPA.service.MovieService;


@RestController
public class MyController {
	@Autowired
	//Client client;
	MovieService wiki;
//posting new movies in my movieList	
	@PostMapping("/movies/addmovie")
	public ResponseEntity<?> addMovie(@RequestBody Movie movie){
		
		wiki.addMovie(movie);
		return new ResponseEntity<String>(HttpStatus.CREATED);
		
	}
	//returning all my movies in my movielist
	@RequestMapping("/movies")
	public ResponseEntity<?> getAllMovies(){
		
		 List<Movie> movies = wiki.getAllMovie(); 
		    return new ResponseEntity<>(movies, HttpStatus.OK); 
	}
//searching for movies by id	
	@RequestMapping("/movies/searchmovie/{Id}")
	public ResponseEntity<?> getMovieById(@PathVariable int Id){
		
		Movie mov=wiki.getMovieById(Id);
		return new ResponseEntity<Movie>(mov,HttpStatus.OK);
	}

//deleting my movie by id from the client
	@RequestMapping("/movies/deletemovie/{Id}")
//	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<?>  deleteById(@PathVariable int Id){
		
		wiki.deleteById(Id);
		return new ResponseEntity<Movie>(HttpStatus.NO_CONTENT);
	}
	
	
	//updating my movie
	
	@RequestMapping("movies/updatemovie")
    @ResponseStatus(HttpStatus.ACCEPTED)
	public void updateMovie(@RequestBody Movie mov){
		 wiki.updateMovie(mov);
		 // new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping("movies/searchmovie/actress/{actressname}")
	@ResponseStatus(HttpStatus.OK)
	public List<Movie> getMovieByActressName(@PathVariable String actressname) {
		List<Movie>actress=wiki.getMovieByActressName(actressname);
		return actress;
		
	}
	
	@RequestMapping("movies/searchmovie/actress/{actressname}/moviename/{moviename}")
	@ResponseStatus(HttpStatus.OK)
	public List<Movie> getMovieByActressNameAndMovieName(@PathVariable String actressname, @PathVariable String moviename) {
		return wiki.getMovieByActressNameAndMovieName(actressname, moviename);
	}
	
	
	
	@RequestMapping("/movies/moviess")
	@ResponseStatus(HttpStatus.OK)
	public List<Movie> sortByMovieName(){
		return wiki.sortbymoviename();
	}

	
	@RequestMapping("/movies/actresss")
	@ResponseStatus(HttpStatus.OK)
	public List<Movie> sortByActressName(){
		return wiki.sortbyactressname();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
