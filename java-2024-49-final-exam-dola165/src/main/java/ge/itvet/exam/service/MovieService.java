package ge.itvet.exam.service;

import ge.itvet.exam.config.Mapper;
import ge.itvet.exam.domain.Movie;
import ge.itvet.exam.model.CreateMovieDto;
import ge.itvet.exam.model.MovieDto;
import ge.itvet.exam.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final ModelMapper modelMapper;
    private final MovieRepository movieRepository;

    /**
     * Create a new Movie.
     */
    public MovieDto createMovie(CreateMovieDto createMovieDto) {
        Movie movie = modelMapper.map(createMovieDto, Movie.class);
        Movie savedMovie = movieRepository.save(movie);
        return modelMapper.map(savedMovie, MovieDto.class);
    }

    /**
     * Retrieve an existing Movie by ID.
     */
    @Transactional
    public MovieDto getMovie(long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id " + id));
        return modelMapper.map(movie, MovieDto.class);
    }

    /**
     * Find movies by name/phrase.
     */
    public List<MovieDto> findMovie(String phrase, boolean includeEpisode) {
        return movieRepository.findMovie("%" + phrase + "%")
                .stream()
                .map(Mapper::convertToDto)
                .peek(movieDto -> {
                    if (!includeEpisode) {
                        movieDto.setEpisodes(null);
                    }
                })
                .collect(Collectors.toList());
    }

    /**
     * Update an existing Movie.
     */
    @Transactional
    public MovieDto updateMovie(long id, CreateMovieDto updatedMovieDto) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id " + id));

        modelMapper.map(updatedMovieDto, movie);
        Movie updated = movieRepository.save(movie);
        return modelMapper.map(updated, MovieDto.class);
    }

    /**
     * Delete an existing Movie.
     */
    @Transactional
    public void deleteMovie(long id) {
        if (!movieRepository.existsById(id)) {
            throw new EntityNotFoundException("Movie not found with id " + id);
        }
        movieRepository.deleteById(id);
    }
}
