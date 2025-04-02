package ge.itvet.exam.repository;

import ge.itvet.exam.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {
    @Query("select m from Movie m where m.name LIKE :name")
    List<Movie> findMovie(@Param("name") String name);
}
