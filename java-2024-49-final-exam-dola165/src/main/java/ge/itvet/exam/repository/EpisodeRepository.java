package ge.itvet.exam.repository;

import ge.itvet.exam.domain.Episode;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EpisodeRepository extends PagingAndSortingRepository<Episode, Long> {
}
