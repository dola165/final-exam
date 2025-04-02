package ge.itvet.exam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDto {
    private int session;
    private int episode;
    private String name;
    private String description;
    private LocalDate releaseDate;
    private double score;
}
