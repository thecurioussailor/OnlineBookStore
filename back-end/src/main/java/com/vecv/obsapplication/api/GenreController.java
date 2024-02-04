package com.vecv.obsapplication.api;

import com.vecv.obsapplication.models.Genres;
import com.vecv.obsapplication.repository.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GenreController {

    private GenresRepository genresRepository;

    @Autowired
    public GenreController(GenresRepository genresRepository) {
        this.genresRepository = genresRepository;
    }

    @GetMapping("/genres")
    public List<Genres> genresList() {
        return genresRepository.findAll();
    }

    @GetMapping("/genres/{genreId}")
    public ResponseEntity<Genres> getGenreById(@PathVariable Long genreId) {

        Optional<Genres> optionalGenres = genresRepository.findById(genreId);

        if (optionalGenres.isPresent()) {
            return ResponseEntity.ok(optionalGenres.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/genres")
    public ResponseEntity<Genres> createGenre(@RequestBody Genres genre) {
        // Save the genre
        Genres createdGenre = genresRepository.save(genre);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdGenre);
    }

    @PutMapping("/genres/{genreId}")
    public ResponseEntity<Genres> updateGenre(@PathVariable Long genreId, @RequestBody Genres updatedGenre) {
        Optional<Genres> optionalGenre = genresRepository.findById(genreId);

        if (optionalGenre.isPresent()) {
            Genres genre = optionalGenre.get();
            genre.setName(updatedGenre.getName());

            // Save the updated genre
            Genres updatedGenreObj = genresRepository.save(genre);
            return ResponseEntity.ok(updatedGenreObj);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/genres/{genreId}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long genreId) {
        Optional<Genres> optionalGenre = genresRepository.findById(genreId);

        if (optionalGenre.isPresent()) {
            genresRepository.delete(optionalGenre.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

