package ge.itvet.exam.config;

import ge.itvet.exam.domain.Episode;
import ge.itvet.exam.domain.Movie;
import ge.itvet.exam.domain.Score;
import ge.itvet.exam.model.EpisodeDto;
import ge.itvet.exam.model.MovieDto;

import java.util.Collection;
import java.util.stream.Collectors;

public class Mapper {
    public static MovieDto convertToDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setDescription(movie.getDescription());
        movieDto.setEpisodes(movie.getEpisodes().stream()
                .map(Mapper::convertToDto)
                .collect(Collectors.toSet()));

        double sum = movieDto.getEpisodes().stream()
                .map(EpisodeDto::getScore)
                .reduce(0., Double::sum);

        if (movieDto.getEpisodes().isEmpty()) {
            movieDto.setScore(0); // or some other default value
        } else {
            movieDto.setScore(sum / movieDto.getEpisodes().size());
        }

        return movieDto;
    }


    public static EpisodeDto convertToDto(Episode episode) {
        EpisodeDto episodeDto = new EpisodeDto();
        episodeDto.setEpisode(episode.getEpisode());
        episodeDto.setName(episode.getName());
        episodeDto.setDescription(episode.getDescription());
        episodeDto.setReleaseDate(episode.getReleaseDate());
        episodeDto.setScore(calculateScore(episode.getScores()));
        return episodeDto;
    }

    public static double calculateScore(Collection<Score> scores) {
        int sum = scores.stream()
                .map(Score::getScore)
                .reduce(0, Integer::sum);
        return ((double) sum) / scores.size();
    }
}
