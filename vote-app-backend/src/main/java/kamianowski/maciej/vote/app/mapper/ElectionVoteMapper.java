package kamianowski.maciej.vote.app.mapper;

import kamianowski.maciej.vote.app.model.ElectionVote;
import kamianowski.maciej.vote.app.payload.ElectionVotePayload;

public class ElectionVoteMapper {
    private ElectionVoteMapper() {}

    public static ElectionVotePayload mapToPayload(ElectionVote model) {
        return ElectionVotePayload
                .builder()
                .candidatePayload(CandidateMapper
                        .mapToPayload(model.getCandidate()))
                .voterPayload(VoterMapper
                        .mapToPayload(model.getVoter()))
                .build();
    }

    public static ElectionVote mapToModel(ElectionVotePayload payload) {
        return ElectionVote
                .builder()
                .candidate(CandidateMapper
                        .mapToModel(payload.getCandidatePayload()))
                .voter(VoterMapper
                        .mapToModel(payload.getVoterPayload()))
                .build();
    }
}
