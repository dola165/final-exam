package ge.itvet.exam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEpisodeDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer session;

    @NotNull
    private int episode;

    @NotBlank
    private String name;

    private String description;

    private LocalDate releaseDate;

}
