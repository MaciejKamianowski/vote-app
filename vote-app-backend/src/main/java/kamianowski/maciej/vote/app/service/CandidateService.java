package kamianowski.maciej.vote.app.service;

import kamianowski.maciej.vote.app.payload.CandidatePayload;

import java.util.List;

public interface CandidateService {
    CandidatePayload getCandidateByName(String name);
    void addOrUpdateCandidate(CandidatePayload payload);
    void deleteCandidate(CandidatePayload payload);
    List<CandidatePayload> getAllCandidates();
}
