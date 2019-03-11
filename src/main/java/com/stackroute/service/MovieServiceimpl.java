package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceimpl {
    private MovieRepository movieRepository;
    @Autowired
    public MovieServiceimpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie saveMovie(Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;
    }

    public List<Movie> getAllMovie() {
        return (List<Movie>) movieRepository.findAll();

    }
    public Movie getMovieById(int id)
    {
        Optional<Movie> foundmoviebyId= movieRepository.findById(id);
        return (Movie) foundmoviebyId.get();
    }
    public void deleteMovie(Movie movie,int Id)
    {
        movieRepository.deleteById(Id);
    }
    public Movie updateMovie(Movie movie, int id)
    {
        Movie findmovie= movieRepository.findById(id).get();
        findmovie.setDetails(movie.getDetails());
        return movieRepository.save(findmovie);
    }
}
