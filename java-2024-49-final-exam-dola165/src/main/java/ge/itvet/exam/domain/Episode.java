package ge.itvet.exam.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private int session;

    @Column(nullable = false)
    private int episode;

    private String name;

    private String description;

    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn
    private Movie movie;

    @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL)
    private List<Score> scores;
}
