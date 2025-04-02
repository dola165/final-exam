package ge.itvet.exam.service;

import ge.itvet.exam.domain.Episode;
import ge.itvet.exam.model.CreateEpisodeDto;
import ge.itvet.exam.model.EpisodeDto;
import ge.itvet.exam.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class EpisodeService {
    private final ModelMapper modelMapper;
    private final EpisodeRepository episodeRepository;

    /**
     * Create a new Episode.
     */
    public EpisodeDto createEpisode(CreateEpisodeDto createEpisodeDto) {
        Episode episode = modelMapper.map(createEpisodeDto, Episode.class);
        Episode savedEpisode = episodeRepository.save(episode);
        return modelMapper.map(savedEpisode, EpisodeDto.class);
    }

    /**
     * Retrieve an existing Episode by ID.
     */
    @Transactional
    public EpisodeDto getEpisode(long id) {
        Episode episode = episodeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Episode not found with id " + id));
        return modelMapper.map(episode, EpisodeDto.class);
    }

    /**
     * Update an existing Episode.
     */
    @Transactional
    public EpisodeDto updateEpisode(long id, CreateEpisodeDto updatedEpisodeDto) {
        Episode episode = episodeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Episode not found with id " + id));

        modelMapper.map(updatedEpisodeDto, episode);
        Episode updated = episodeRepository.save(episode);
        return modelMapper.map(updated, EpisodeDto.class);
    }

    /**
     * Delete an existing Episode.
     */
    @Transactional
    public void deleteEpisode(long id) {
        if (!episodeRepository.existsById(id)) {
            throw new EntityNotFoundException("Episode not found with id " + id);
        }
        episodeRepository.deleteById(id);
    }
}
