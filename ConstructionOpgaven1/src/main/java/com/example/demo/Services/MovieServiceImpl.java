package com.example.demo.Services;

import com.example.demo.Model.Movie;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private List<Movie> movies = new ArrayList<>();
    private List<Movie> moviesS = new ArrayList<>();
    private List<Movie> ratings = new ArrayList<>();


    private MovieService movieService;

    public MovieServiceImpl(){
        generate();
    }


    

    @Override
    public void save(Movie mov) {
        movies.add(mov);
    }
    @Override
    public void saveRating(Movie mov) {
        ratings.add(mov);
    }


    @Override
    public void update(Movie mov) {
        movies.set(mov.getId(), mov);
    }

    @Override
    public void delete(int id) {
        movies.remove(id);
    }

    @Override
    public List<Movie> changer(){

        for (int i = 0; i<movies.size();){

            movies.get(i).setId(i);
            i++;
        }
        return(movies);
    }

    @Override
    public List<Movie> search(String sea){

        moviesS.clear();

        for (int i = 0; i<movies.size();){

            if(movies.get(i).getTitle().toLowerCase().contains(sea.toLowerCase()) || movies.get(i).getGenre().toLowerCase().contains(sea.toLowerCase()) || sea.equals(movies.get(i).getTableN())){
                moviesS.add(movies.get(i));
            }
            i++;
        }




        return moviesS;
    }



    @Override
    public Movie findById(int id) {
        return movies.get(id);
    }

    @Override
    public void updateRating() {
        double ratingtemp = 0;
        int ratingcount = 0;

        for (int i = 0; i < movies.size() && i < ratings.size(); ) {

            ratingtemp = 0;
            ratingcount = 0;



            for (int k = 0; k < ratings.size(); ) {

                if (movies.get(i).getTitle().equals(ratings.get(k).getTitle())) {
                    ratingtemp += ratings.get(k).getRating();
                    ratingcount ++;
                }
                k++;

            }



            movies.get(i).setRating(Math.round((ratingtemp/ratingcount)*10)/10.0);


            i++;
        }
    }





    public void generate(){
        movies.add(new Movie(0,"Itamrfilm", "gyser", "2019",1.58 ,0,"https://www.youtube.com/embed/SiO_7LhPZFM" ));
        movies.add(new Movie(1,"Benjasfilm", "goodfilm", "1997",2.56,0,"https://www.youtube.com/embed/7H4lDi79YY8"));
        movies.add(new Movie(2,"AdilsFilm", "adilerfilm", "1996", 2.44, 0, "https://www.youtube.com/embed/5R8EpAv4miA"));
        movies.add(new Movie(3, "Spaceysang", "spacemusic", "1956", 4.13, 0, "https://www.youtube.com/embed/U4U19zwFENs" ));
        movies.add(new Movie(4, "HistoryE", "history", "2019", 25.34, 0, "https://www.youtube.com/embed/BVDZjLjIasA" ));
        movies.add(new Movie(5, "Amalgam", "chemistry", "2019", 8.34, 0, "https://www.youtube.com/embed/IrdYueB9pY4" ));
    }



}
