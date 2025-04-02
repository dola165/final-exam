package ge.itvet.exam.model;

import ge.itvet.exam.domain.Score;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDto {
    private String personalNo;
    private int score;
    private String episodeName;
}