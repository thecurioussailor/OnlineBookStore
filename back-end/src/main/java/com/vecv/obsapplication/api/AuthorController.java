package com.vecv.obsapplication.api;

import com.vecv.obsapplication.models.Author;
import com.vecv.obsapplication.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public List<Author> authorList() {
        return authorRepository.findAll();
    }

    @GetMapping("/authors/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long authorId){
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if (optionalAuthor.isPresent()){
            return ResponseEntity.ok(optionalAuthor.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


    // Create a new author
    @PostMapping("/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){

        //save the author
        Author createAuthor = authorRepository.save(author);

        return ResponseEntity.status(HttpStatus.CREATED).body(createAuthor);

    }
    //put method for author
    @PutMapping("/authors/{authorId}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long authorId, @RequestBody Author updatedAuthor) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if (optionalAuthor.isPresent()) {
            Author existingAuthor = optionalAuthor.get();
            existingAuthor.setFirstName(updatedAuthor.getFirstName());
            existingAuthor.setLastName(updatedAuthor.getLastName());
            existingAuthor.setBirthDate(updatedAuthor.getBirthDate());
            existingAuthor.setNationality(updatedAuthor.getNationality());
            existingAuthor.setBiography(updatedAuthor.getBiography());
            existingAuthor.setWebsite(updatedAuthor.getWebsite());

            Author updatedAuthorEntity = authorRepository.save(existingAuthor);
            return ResponseEntity.ok(updatedAuthorEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //Delete an author
    @DeleteMapping("/authors/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long authorId) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if (optionalAuthor.isPresent()) {
            authorRepository.delete(optionalAuthor.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

