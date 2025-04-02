package ge.itvet.exam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private long id;
    private String description;
    private LocalDate releaseDate;
    private double score;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<EpisodeDto> episodes;
}
