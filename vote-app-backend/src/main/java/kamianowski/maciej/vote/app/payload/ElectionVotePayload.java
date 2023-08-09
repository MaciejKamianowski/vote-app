package kamianowski.maciej.vote.app.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElectionVotePayload {
    private CandidatePayload candidatePayload;
    private VoterPayload voterPayload;
}
