package com.springstartboot.com.springstartbootRestJPA.model;

import jakarta.persistence.*;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String movieName;
	private String actressName;
	
	
	
	public Movie() {
		
	}
	public Movie(String movieName, String actressName) {
		//this.id = id;
		this.movieName = movieName;
		this.actressName = actressName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getActressName() {
		return actressName;
	}
	public void setActressName(String actressName) {
		this.actressName = actressName;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", actressName=" + actressName + "]";
	}
		
	
	

}
