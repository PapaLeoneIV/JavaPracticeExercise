package com.ric.api.movie;

import com.ric.api.product.Product;

public class Movie extends Product{
    private String title;
    private String genre;
    private int duration;

    public Movie(long id, String category, String productionCountry, String genre, String title,  int duration) {
        super(id, category, productionCountry);
        setTitle(title);
        setGenre(genre);
        setDuration(duration);
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return String return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString(){
        return ("Movie: " + getTitle()+ " " + getCategory() + " " + getProductionCountry() + " " + getGenre() + " " + getDuration());
    }
}
