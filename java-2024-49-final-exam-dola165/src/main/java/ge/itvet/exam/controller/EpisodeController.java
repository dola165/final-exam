package ge.itvet.exam.controller;

import ge.itvet.exam.model.CreateEpisodeDto;
import ge.itvet.exam.model.EpisodeDto;
import ge.itvet.exam.service.EpisodeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/episodes")
@Log4j2
public class EpisodeController {

    private final EpisodeService episodeService;

    /**
     * Create a new Episode.
     */
    @PostMapping
    @Operation(summary = "Create a new Episode")
    public ResponseEntity<EpisodeDto> createEpisode(@Valid @RequestBody CreateEpisodeDto createEpisodeDto) {
        log.info("Received request to create Episode: {}", createEpisodeDto);
        EpisodeDto episodeDto = episodeService.createEpisode(createEpisodeDto);
        log.info("Episode created successfully: {}", episodeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(episodeDto);
    }

    /**
     * Retrieve an existing Episode by ID.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get an Episode by ID")
    public ResponseEntity<EpisodeDto> getEpisode(@PathVariable long id) {
        log.info("Fetching Episode with ID: {}", id);
        EpisodeDto episodeDto = episodeService.getEpisode(id);
        return ResponseEntity.ok(episodeDto);
    }

    /**
     * Update an existing Episode.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing Episode")
    public ResponseEntity<EpisodeDto> updateEpisode(@PathVariable long id, @Valid @RequestBody CreateEpisodeDto updatedEpisode) {
        log.info("Updating Episode with ID: {}", id);
        EpisodeDto updated = episodeService.updateEpisode(id, updatedEpisode);
        log.info("Episode updated successfully: {}", updated);
        return ResponseEntity.ok(updated);
    }

    /**
     * Delete an existing Episode.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an Episode")
    public ResponseEntity<Void> deleteEpisode(@PathVariable long id) {
        log.info("Deleting Episode with ID: {}", id);
        episodeService.deleteEpisode(id);
        return ResponseEntity.noContent().build();
    }
}
