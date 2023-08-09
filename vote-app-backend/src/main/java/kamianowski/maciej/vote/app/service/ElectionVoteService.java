package kamianowski.maciej.vote.app.service;

import kamianowski.maciej.vote.app.payload.ElectionVotePayload;

public interface ElectionVoteService {
    void castVote(ElectionVotePayload electionVotePayload);
    boolean checkIfVoterCastedElectionVote(Long voterId);
    Long getNumberOfElectionVotesForCandidate(Long candidateId);
}
