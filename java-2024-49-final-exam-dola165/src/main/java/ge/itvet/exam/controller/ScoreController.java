package ge.itvet.exam.controller;

import ge.itvet.exam.model.ScoreDto;
import ge.itvet.exam.model.CreateScoreDto;
import ge.itvet.exam.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scores")
public class ScoreController {

    private final ScoreService scoreService;

    /**
     * Create a new Score.
     */
    @PostMapping
    public ResponseEntity<ScoreDto> createScore(@Valid @RequestBody CreateScoreDto createScoreDto) {
        ScoreDto createdScore = scoreService.createScore(createScoreDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdScore);
    }

    /**
     * Retrieve an existing Score by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ScoreDto> getScore(@PathVariable long id) {
        ScoreDto score = scoreService.getScore(id);
        return ResponseEntity.ok(score);
    }

    /**
     * Retrieve all Scores for a specific Episode.
     */
    @GetMapping("/episode/{episodeId}")
    public ResponseEntity<List<ScoreDto>> getScoresForEpisode(@PathVariable long episodeId) {
        return ResponseEntity.ok(scoreService.getScoresForEpisode(episodeId));
    }

    /**
     * Update an existing Score.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ScoreDto> updateScore(@PathVariable long id, @Valid @RequestBody CreateScoreDto updatedScoreDto) {
        ScoreDto updated = scoreService.updateScore(id, updatedScoreDto);
        return ResponseEntity.ok(updated);
    }

    /**
     * Delete an existing Score.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable long id) {
        scoreService.deleteScore(id);
        return ResponseEntity.noContent().build();
    }
}
