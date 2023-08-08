package kamianowski.maciej.vote.app.mapper;

import kamianowski.maciej.vote.app.model.Voter;
import kamianowski.maciej.vote.app.payload.VoterPayload;

public class VoterMapper {
    private VoterMapper() {}

    public static Voter mapToModel(VoterPayload payload) {
        return Voter
                .builder()
                .id(payload.getId())
                .name(payload.getName())
                .build();
    }

    public static VoterPayload mapToPayload(Voter model) {
        return VoterPayload
                .builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}
