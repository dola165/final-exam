package ge.itvet.exam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateScoreDto {
    @NotNull
    @Size(min = 11, max = 11)
    private String personalNo;

    @Min(1)
    @Max(10)
    private int score;

    @NotNull
    private Long episodeId;


}

