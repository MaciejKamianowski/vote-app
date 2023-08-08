package kamianowski.maciej.vote.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_voters")
public class Voter {
    @Id
    @SequenceGenerator(
            name = "voter_sequence",
            sequenceName = "voter_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "voter_sequence"
    )
    private Long id;
    private String name;
}
