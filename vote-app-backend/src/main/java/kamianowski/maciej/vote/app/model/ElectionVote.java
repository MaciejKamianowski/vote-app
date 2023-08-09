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
@Table(name = "_election_votes")
public class ElectionVote {
    @Id
    @SequenceGenerator(
            name = "election_vote_sequence",
            sequenceName = "election_vote_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "election_vote_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @OneToOne
    @JoinColumn(name = "voter_id")
    private Voter voter;
}
