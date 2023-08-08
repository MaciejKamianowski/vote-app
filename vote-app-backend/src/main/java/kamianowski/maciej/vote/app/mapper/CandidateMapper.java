package kamianowski.maciej.vote.app.mapper;

import kamianowski.maciej.vote.app.model.Candidate;
import kamianowski.maciej.vote.app.payload.CandidatePayload;

public class CandidateMapper {
    private CandidateMapper() {}

    public static Candidate mapToModel(CandidatePayload payload) {
        return Candidate
                .builder()
                .id(payload.getId())
                .name(payload.getName())
                .build();
    }

    public static CandidatePayload mapToPayload(Candidate model) {
        return CandidatePayload
                .builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}
