package ge.itvet.exam.service;

import ge.itvet.exam.domain.Episode;
import ge.itvet.exam.domain.Score;
import ge.itvet.exam.model.ScoreDto;
import ge.itvet.exam.model.CreateScoreDto;
import ge.itvet.exam.repository.ScoreRepository;
import ge.itvet.exam.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;
    private final EpisodeRepository episodeRepository;
    private final ModelMapper modelMapper;

    /**
     * Create a new Score.
     */
    @Transactional
    public ScoreDto createScore(CreateScoreDto createScoreDto) {
        Episode episode = episodeRepository.findById(createScoreDto.getEpisodeId())
                .orElseThrow(() -> new EntityNotFoundException("Episode not found with id " + createScoreDto.getEpisodeId()));

        Score score = modelMapper.map(createScoreDto, Score.class);
        score.setEpisode(episode);

        Score savedScore = scoreRepository.save(score);
        return modelMapper.map(savedScore, ScoreDto.class);
    }

    /**
     * Retrieve an existing Score by ID.
     */
    public ScoreDto getScore(long id) {
        Score score = scoreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Score not found with id " + id));
        return modelMapper.map(score, ScoreDto.class);
    }

    /**
     * Retrieve all Scores for a given Episode.
     */
    public List<ScoreDto> getScoresForEpisode(long episodeId) {
        List<Score> scores = scoreRepository.findByEpisodeId(episodeId);
        return scores.stream()
                .map(score -> modelMapper.map(score, ScoreDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Update an existing Score.
     */
    @Transactional
    public ScoreDto updateScore(long id, CreateScoreDto updatedScoreDto) {
        Score existingScore = scoreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Score not found with id " + id));

        Episode episode = episodeRepository.findById(updatedScoreDto.getEpisodeId())
                .orElseThrow(() -> new EntityNotFoundException("Episode not found with id " + updatedScoreDto.getEpisodeId()));

        modelMapper.map(updatedScoreDto, existingScore);
        existingScore.setEpisode(episode);

        Score updatedScore = scoreRepository.save(existingScore);
        return modelMapper.map(updatedScore, ScoreDto.class);
    }

    /**
     * Delete an existing Score.
     */
    @Transactional
    public void deleteScore(long id) {
        if (!scoreRepository.existsById(id)) {
            throw new EntityNotFoundException("Score not found with id " + id);
        }
        scoreRepository.deleteById(id);
    }
}
