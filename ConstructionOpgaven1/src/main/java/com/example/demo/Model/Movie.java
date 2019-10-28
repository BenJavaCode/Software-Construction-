package com.example.demo.Model;


public class Movie {

private int id;
private String title;
private String genre;
private String year;
private double duration;
private double rating;
private String path;
private String tableN;


public Movie(){

}

    public Movie(int id, String title, String genre, String year, double duration, double rating, String path) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
        this.rating = rating;
        this.path = path;
    }

    public Movie(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getTableN() {
        return tableN;
    }

    public void setTableN(String tableN) {
        this.tableN = tableN;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", year='" + year + '\'' +
                ", duration=" + duration +
                ", rating=" + rating +
                ", path='" + path + '\'' +
                ", tableN='" + tableN + '\'' +
                '}';
    }
}
