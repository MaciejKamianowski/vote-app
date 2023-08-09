package kamianowski.maciej.vote.app.repository;

import kamianowski.maciej.vote.app.model.ElectionVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ElectionVoteRepository extends JpaRepository<ElectionVote, Long> {
    @Query(
            value = "SELECT COUNT(ev.id) FROM _election_votes ev\n" +
                    "WHERE ev.voter_id = :voterId",
            nativeQuery = true)
    Long getNumberOfElectionVotesForVoter(Long voterId);
    @Query(
            value = "SELECT COUNT(ev.id) FROM _election_votes ev\n" +
                    "WHERE ev.candidate_id = :candidateId",
            nativeQuery = true)
    Long getNumberOfElectionVotesForCandidate(Long candidateId);
}
