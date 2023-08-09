package kamianowski.maciej.vote.app.service;

import kamianowski.maciej.vote.app.payload.VoterInfoPayload;
import kamianowski.maciej.vote.app.payload.VoterPayload;

import java.util.List;

public interface VoterService {
    VoterPayload getVoterByName(String name);
    void addOrUpdateVoter(VoterPayload payload);
    void deleteVoter(VoterPayload payload);
    List<VoterPayload> getAllVoters();
    List<VoterInfoPayload> getAllVotersInfo();
}
