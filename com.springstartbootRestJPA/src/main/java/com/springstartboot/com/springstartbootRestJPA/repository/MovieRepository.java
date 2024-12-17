package com.springstartboot.com.springstartbootRestJPA.repository;

import java.util.*;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springstartboot.com.springstartbootRestJPA.model.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

	List<Movie> findByactressName(String actressName);

	List<Movie> findByActressNameAndMovieName(String actressName, String movieName);
	
	@Query("select m from Movie m")
	List<Movie> findAll(Sort s);
	
}
