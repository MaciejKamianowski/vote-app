package kamianowski.maciej.vote.app.repository;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import jakarta.persistence.Query;
import java.util.List;

@Repository
@AllArgsConstructor
public class CandidateInfoRepository {
    private final EntityManager entityManager;
     public List getInfoAboutAllCandidates() {
        Query query = entityManager.createNativeQuery("SELECT c.id, c.name, COUNT(ev.id) FROM _candidates c\n" +
                "LEFT JOIN _election_votes ev \n" +
                "ON c.id = ev.candidate_id\n" +
                "GROUP BY c.id");

        return query.getResultList();
    }
}
