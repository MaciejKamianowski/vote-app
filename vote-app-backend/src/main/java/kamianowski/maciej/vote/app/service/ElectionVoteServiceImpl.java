package kamianowski.maciej.vote.app.service;

import kamianowski.maciej.vote.app.mapper.CandidateMapper;
import kamianowski.maciej.vote.app.model.Candidate;
import kamianowski.maciej.vote.app.model.ElectionVote;
import kamianowski.maciej.vote.app.model.Voter;
import kamianowski.maciej.vote.app.payload.ElectionVotePayload;
import kamianowski.maciej.vote.app.payload.VoterPayload;
import kamianowski.maciej.vote.app.repository.ElectionVoteRepository;
import kamianowski.maciej.vote.app.repository.VoterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElectionVoteServiceImpl implements ElectionVoteService{

    final private ElectionVoteRepository electionVoteRepository;
    final private VoterRepository voterRepository;
    @Override
    public void castVote(ElectionVotePayload electionVotePayload) {
        String voterName = electionVotePayload
                .getVoterPayload()
                .getName();

        Voter voter = voterRepository
                .findByName(voterName)
                .orElseThrow(() -> new RuntimeException("Voter: " + voterName + " not found!"));
        if (voter.getVote() != null) {
            throw new RuntimeException("Voter has already voted.");
        }

        Candidate candidate = CandidateMapper.mapToModel(electionVotePayload.getCandidatePayload());
        ElectionVote electionVote = ElectionVote
                .builder()
                .voter(voter)
                .candidate(candidate)
                .build();
        electionVoteRepository.save(electionVote);
    }

    @Override
    public boolean checkIfVoterCastedElectionVote(Long voterId) {
        return Boolean.TRUE.equals(
                electionVoteRepository
                        .getNumberOfElectionVotesForVoter(voterId) > 0);
    }

    @Override
    public Long getNumberOfElectionVotesForCandidate(Long candidateId) {
        return electionVoteRepository.getNumberOfElectionVotesForCandidate(candidateId);
    }
}
