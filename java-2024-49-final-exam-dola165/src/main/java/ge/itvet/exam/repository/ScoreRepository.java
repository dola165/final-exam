package ge.itvet.exam.repository;

import ge.itvet.exam.domain.Score;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ScoreRepository extends PagingAndSortingRepository<Score, Long> {
    List<Score> findByEpisodeId(Long episodeId);
}
