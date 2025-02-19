package com.ric.api.database;

import java.util.List;

import com.ric.api.director.Director;


public class Database {
    private static Database instance;
    
    private final List<Director> directors;


    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private Database() {
        this.directors = new java.util.ArrayList<>();
    }


    public Director getDirector(long id) {
        for (Director director : directors) {
            if (director.getId() == id) {
                return director;
            }
        }
        return null;
    }


    public boolean deleteDirector(long id){
        for (Director director : directors) {
            if(director.getId() == id){
                directors.remove(director);
                return true;
            }
        }
        return false;
    }


    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directorsList) {
        for (Director director : directorsList) {
            this.directors.add(director);
        }
    }

    public void setDirector(Director director){
        this.directors.add(director);
    }

    public void printDB(){
        for (Director director : directors) {
            System.out.println(director.toString());
        }
    }
}
