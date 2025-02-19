package com.ric.api.director;

import java.util.List;

import com.ric.api.movie.Movie;
import com.ric.api.person.Person;

public class Director extends Person {
    private String sector;
    final private List<Movie> movies;

    public Director(long id, String name, String lastName, String email, String sector, List<Movie> movies) {
        super(id, name, lastName, email); 
        this.movies = new java.util.ArrayList<>();
        setSector(sector);
        setMovie(movies);
    }

    public Director(long id, String name, String lastName, String email, String sector) {
        super(id, name, lastName, email); 
        this.movies = new java.util.ArrayList<>();
        setSector(sector);
    }

    public Movie getMovie(long id){
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public String getSector() {
        return sector;
    }

    
    final public void setSector(String sector) {
        this.sector = sector;
    }

    
    public List<Movie> getMovies() {
        return movies;
    }

    
    final public void setMovie(List<Movie> moviesArray) {
        if(moviesArray == null){
            return;
        }
        for (Movie movie : moviesArray) {
            this.movies.add(movie); 
        }
    }
    
    @Override
    public String toString(){
        List<Movie> movieList = getMovies();
        
        String info = "Director: " + getName() + " " + getLastName() + " " + getEmail() + " " + getSector() + "\n";
        
        for (Movie movie : movieList) {
            info += movie.toString() + "\n";
        }
        return info;
    }   

}
