package kamianowski.maciej.vote.app.repository;

import kamianowski.maciej.vote.app.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VoterRepository extends JpaRepository<Voter, Long> {
    Optional<Voter> findByName(String name);

    @Query(
            value = "SELECT * FROM _voters v\n" +
                    "ORDER BY v.id",
            nativeQuery = true)
    List<Voter> getAllVotersSorted();
}
