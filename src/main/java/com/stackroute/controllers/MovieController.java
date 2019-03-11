package com.stackroute.controllers;
import com.stackroute.domain.Movie;
import com.stackroute.service.MovieServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MovieController {
    private MovieServiceimpl movieServiceimpl;

    @Autowired
    public MovieController(MovieServiceimpl movieServiceimpl) {
        this.movieServiceimpl = movieServiceimpl;
    }

    @PostMapping("/movie")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {

        Movie savedMovie = (Movie) movieServiceimpl.saveMovie(movie);
        return new ResponseEntity<Movie>(savedMovie, HttpStatus.OK);
    }

    @GetMapping(value = "/movies")
    public ResponseEntity<List<Movie>> getAllMovie(@RequestBody Movie movie) {

        return new ResponseEntity<List<Movie>>(movieServiceimpl.getAllMovie(), HttpStatus.OK);

    }
    @GetMapping(value = "/movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Movie getMovieById= (Movie) movieServiceimpl.getMovieById(id);
        return new ResponseEntity<Movie>(getMovieById, HttpStatus.OK);

    }
    @DeleteMapping(value = "/movie/{id}")
    public ResponseEntity<List<Movie>> deleteUser(@PathVariable int id) {

        return new ResponseEntity<List<Movie>>(movieServiceimpl.getAllMovie(), HttpStatus.OK);
    }
    @PutMapping("/movie/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int id,@RequestBody Movie movie){
        Movie updatedMovie= movieServiceimpl.updateMovie(movie, id);
        return new ResponseEntity<Movie>(updatedMovie,HttpStatus.OK);
    }
}
