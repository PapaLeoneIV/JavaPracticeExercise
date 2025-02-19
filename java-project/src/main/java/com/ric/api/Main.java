package com.ric.api;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import com.ric.api.database.Database;
import com.ric.api.director.Director;
import com.ric.api.handler.DirectorHandler;
import com.ric.api.movie.Movie;
import com.sun.net.httpserver.HttpServer;

public class Main {
    public static void main(String[] args) {
        
        
        
        Database db = Database.getInstance();
        
        //init database with some value---
        List<Movie> movies = new ArrayList<>();
        Movie m1 = new Movie(1, "Cinema", "Italy", "Thriller", "VVitch", 120);
        Movie m2 = new Movie(1, "Cinema", "England", "Horror", "Rocky Horror",  90);
        movies.add(m1);
        movies.add(m2);
        Director d1 = new Director(1, "Riccardo", "Leone", "abc@gmail.com", "Cinema", movies);
        Director d2 = new Director(2, "Antonio", "Leone", "123@gmail.com", "Teatro", movies);
        db.setDirector(d1);
        db.setDirector(d2);
        //--------------------------------
        
        HttpServer server = null;
        String host = "localhost";
        int port = 8000;

        try {
            server = HttpServer.create(new InetSocketAddress(host, port), 0);
            server.createContext("/api/director", new DirectorHandler(db));
            server.setExecutor(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        System.out.println("Server started on ==> "+ host + ":" + port);
        //start listening on localhost:8080
        server.start();
    }
}