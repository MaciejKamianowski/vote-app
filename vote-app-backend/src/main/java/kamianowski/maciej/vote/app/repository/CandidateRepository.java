package kamianowski.maciej.vote.app.repository;

import kamianowski.maciej.vote.app.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Optional<Candidate> findByName(String name);
}
