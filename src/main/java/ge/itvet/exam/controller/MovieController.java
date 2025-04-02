package ge.itvet.exam.controller;

import ge.itvet.exam.model.CreateMovieDto;
import ge.itvet.exam.model.MovieDto;
import ge.itvet.exam.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
@Log4j2
public class MovieController {

    private final MovieService movieService;

    /**
     * Create a new Movie.
     */
    @PostMapping
    @Operation(summary = "Create a new Movie")
    public ResponseEntity<MovieDto> createMovie(@Valid @RequestBody CreateMovieDto createMovieDto) {
        log.info("Received request to create Movie: {}", createMovieDto);
        MovieDto movieDto = movieService.createMovie(createMovieDto);
        log.info("Movie created successfully: {}", movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDto);
    }

    /**
     * Retrieve an existing Movie by ID.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get a Movie by ID")
    public ResponseEntity<MovieDto> getMovie(@PathVariable long id) {
        log.info("Fetching Movie with ID: {}", id);
        MovieDto movieDto = movieService.getMovie(id);
        return ResponseEntity.ok(movieDto);
    }

    /**
     * Find a Movie by name.
     */
    @GetMapping
    @Operation(summary = "Find a Movie by name")
    public ResponseEntity<List<MovieDto>> findMovie(@RequestParam String phrase, @RequestParam boolean includeEpisode) {
        log.info("Searching for movies with phrase: {} and includeEpisode: {}", phrase, includeEpisode);
        List<MovieDto> movieDto = movieService.findMovie(phrase, includeEpisode);
        return ResponseEntity.ok(movieDto);
    }

    /**
     * Update an existing Movie.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing Movie")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable long id, @Valid @RequestBody CreateMovieDto updatedMovie) {
        log.info("Updating Movie with ID: {}", id);
        MovieDto updated = movieService.updateMovie(id, updatedMovie);
        log.info("Movie updated successfully: {}", updated);
        return ResponseEntity.ok(updated);
    }

    /**
     * Delete an existing Movie.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Movie")
    public ResponseEntity<Void> deleteMovie(@PathVariable long id) {
        log.info("Deleting Movie with ID: {}", id);
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
