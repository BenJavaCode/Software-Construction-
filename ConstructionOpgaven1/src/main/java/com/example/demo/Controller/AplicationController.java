package com.example.demo.Controller;

import com.example.demo.Model.Movie;
import com.example.demo.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class AplicationController {

    @Autowired
    private MovieService movieService;


    @GetMapping("/")
    public String movies(Model model, @RequestParam(defaultValue = "") String sea){



        movieService.updateRating();
        model.addAttribute("movies", movieService.search(sea));
        model.addAttribute("ratings", new Movie());

        return "all";
    }

    @PostMapping("/")
    public String movies(@ModelAttribute Movie movie, Model model){

        movieService.updateRating();
        movieService.saveRating(movie);

        return "redirect:/";
    }


    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("movie", new Movie());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Movie movie,Model model) {

        movieService.save(movie);
        movieService.changer();

        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id , Model model){

        model.addAttribute("movie", movieService.findById(id));

        return "update";
    }

    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute Movie movie,Model model){

        movieService.update(movie);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable int id, Model model){

        model.addAttribute(movieService.changer());
        movieService.delete(id);
        model.addAttribute(movieService.changer());


        return "redirect:/";
    }

    @GetMapping("/movieInfo/{id}")
    public String read (@PathVariable int id, Model model){

        model.addAttribute("movie", movieService.findById(id));

        return "movieInfo";
    }

}
