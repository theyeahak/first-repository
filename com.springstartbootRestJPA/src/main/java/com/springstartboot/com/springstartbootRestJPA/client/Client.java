package com.springstartboot.com.springstartbootRestJPA.client;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springstartboot.com.springstartbootRestJPA.model.Movie;
import com.springstartboot.com.springstartbootRestJPA.repository.MovieRepository;

//@Component
@Service
public class Client implements CommandLineRunner {
	
	@Autowired
    private MovieRepository repo;
    
	public Client(MovieRepository repo) {
		
		this.repo = repo;
	}



	@Override
	public void run(String... args) throws Exception {
		
//	Movie m1=new Movie("jailer","tamannah" );
//		Movie m2=new Movie("Aadhi","trisha" );
//		Movie m3=new Movie("billa","nayanthara" );
//		Movie m4=new Movie("baahubali","anushka" );
//		repo.save(m1);
//		repo.save(m2);
//    	repo.save(m3);
//		repo.save(m4);
//	
//		
//		//read data
//		
//		List<Movie>movieList=repo.findAll();
//		System.out.println("mymovies"+movieList);
//		
//		//read by id
//		Optional<Movie> mmm=repo.findById(2);
//		System.out.println(mmm.get());
//		
//		//update particular data in table
//		
//		Optional<Movie> aadhiMovie=repo.findById(2);
////		Movie mma=aadhiMovie.get();
////         mma.setActressName("keethi");
////		repo.save(mma);
//		aadhiMovie.get().setActressName("suresh");
//		repo.save(aadhiMovie.get());
//		
//		
////my custom method in interface for findbyactressname
//		
//		List<Movie> tamannah=repo.findByactressName("tamannah");
//		System.out.println("trisha movies: ---->"+tamannah);
//		
//		//using two columns to search yu must start the membervariables in uppercase while creating custom method
//		List<Movie>tamannahjailer=repo.findByActressNameAndMovieName("tamannah", "jailer");
//		System.out.println("---------->"+tamannahjailer);
//	
//		
//		//sorting using my custom sort methods
//		Iterator<Movie> it=repo.findAll(Sort.by("movieName")).iterator();
//		System.out.println("sort the list by Movie-Name: ");
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//		
//		
//		Iterator<Movie> ita=repo.findAll(Sort.by("actressName")).iterator();
//		System.out.println("sort by actress name: ");
//		while(ita.hasNext()) {
//			System.out.println(ita.next());
//		}
		
		
		//create or add operation.,.,add movies/create movies
	}
	public void addMovie(Movie movie) {
		repo.save(movie);
	}
	
	//read all .,.get all of movies
	
	public List<Movie> getallMovie(){
		List<Movie> allmovies=repo.findAll();
		return allmovies;
	}
	
	//get movie by id
	public Movie getMovieById(int Id) {
		return repo.findById(Id).get();
		
	}
	
	
	

}
