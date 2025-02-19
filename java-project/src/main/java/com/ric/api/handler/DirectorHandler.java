package com.ric.api.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

import org.json.JSONObject;

import com.ric.api.database.Database;
import com.ric.api.director.Director;
import com.ric.api.interfaces.Preaparedata;
import com.ric.api.movie.Movie;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class DirectorHandler implements HttpHandler, Preaparedata {

    private final Database db;

    public DirectorHandler(Database db) {
        this.db = db;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String responseText = "";
        try {
            switch (exchange.getRequestMethod()) {
                case "GET":
                    responseText = handleGetRequest(exchange);
                    break;
                case "POST":
                    responseText = handlePostRequest(exchange);
                    break;
                case "PUT":
                    responseText = handlePutRequest(exchange);
                    break;
                case "DELETE":
                    responseText = handleDeleteRequest(exchange);
                    break;
                default:
                    responseText = "Method not allowed!";
                    exchange.sendResponseHeaders(405, responseText.getBytes().length); 
                    break;
            }
        } catch (Exception e) {
            responseText = "Internal Server Error: " + e.getMessage();
            exchange.sendResponseHeaders(500, responseText.getBytes().length);
        } finally {
            sendResponse(exchange, responseText);
        }
    }

    private void sendResponse(HttpExchange exchange, String responseText) throws IOException {
        exchange.sendResponseHeaders(200, responseText.getBytes().length);
        try (OutputStream output = exchange.getResponseBody()) {
            output.write(responseText.getBytes());
            output.flush();
        }
        exchange.close();
    }

    private String handleGetRequest(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();
        if (query == null || !query.startsWith("id=")) {
            return "Invalid query!";
        }

        long id = Long.parseLong(query.split("=")[1]);
        return prepareJson(id);
    }

    private String handlePostRequest(HttpExchange exchange) throws IOException {
        JSONObject json = parseJsonRequest(exchange);
        Director director = createDirectorFromJson(json);
        db.setDirector(director);
        return prepareJson(director.getId());
    }

    private String handlePutRequest(HttpExchange exchange) throws IOException {
        String queryParamString = exchange.getRequestURI().getQuery();
        if (queryParamString == null || !queryParamString.startsWith("id=")) {
            return "Invalid query!";
        }

        long id = Long.parseLong(queryParamString.split("=")[1]);
        JSONObject json = parseJsonRequest(exchange);
        updateDirectorFromJson(id, json);
        return "Director updated!";
    }

    private String handleDeleteRequest(HttpExchange exchange) throws IOException {
        String queryParamString = exchange.getRequestURI().getQuery();
        if (queryParamString == null || !queryParamString.startsWith("id=")) {
            return "Invalid query!";
        }

        long id = Long.parseLong(queryParamString.split("=")[1]);
        if (db.deleteDirector(id)) {
            return "Director deleted!";
        } else {
            return "Director not found!";
        }
    }

    private JSONObject parseJsonRequest(HttpExchange exchange) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody(), "utf-8"));
        StringBuilder body = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            body.append(line);
        }
        return new JSONObject(body.toString());
    }

    private Director createDirectorFromJson(JSONObject json) {
        String id = json.getString("id");
        String name = json.getString("name");
        String lastname = json.getString("lastname");
        String email = json.getString("email");
        String sector = json.getString("sector");

        return new Director(Long.parseLong(id), name, lastname, email, sector);
    }

    private void updateDirectorFromJson(long id, JSONObject json) {
        Director director = db.getDirector(id);
        if (director == null) {
            return;
        }

        json.keys().forEachRemaining(key -> {
            switch (key) {
                case "name":
                    director.setName(json.getString(key));
                    break;
                case "lastname":
                    director.setLastName(json.getString(key));
                    break;
                case "email":
                    director.setEmail(json.getString(key));
                    break;
                case "sector":
                    director.setSector(json.getString(key));
                    break;
                default:
                    System.out.println("Unrecognized field: " + key);
            }
        });
    }

    @Override
    public String prepareJson(long resourceId) {
        Director director = db.getDirector(resourceId);
        if (director == null) {
            return "{}";  // Return empty JSON if the director is not found
        }

        List<Movie> movies = director.getMovies();
        StringBuilder movieJson = new StringBuilder();
        for (Movie movie : movies) {
            if (movieJson.length() > 0) {
                movieJson.append(",");
            }
            movieJson.append("{" +
                    "\"title\": \"" + movie.getTitle() + "\", " +
                    "\"category\": \"" + movie.getCategory() + "\", " +
                    "\"country\": \"" + movie.getProductionCountry() + "\", " +
                    "\"genre\": \"" + movie.getGenre() + "\", " +
                    "\"duration\": " + movie.getDuration() +
                    "}");
        }

        return "{" +
                "\"name\": \"" + director.getName() + "\", " +
                "\"lastname\": \"" + director.getLastName() + "\", " +
                "\"email\": \"" + director.getEmail() + "\", " +
                "\"sector\": \"" + director.getSector() + "\", " +
                "\"movies\": [" + movieJson.toString() + "]" +
                "}";
    }
}
