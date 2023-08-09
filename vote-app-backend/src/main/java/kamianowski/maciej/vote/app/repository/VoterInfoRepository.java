package kamianowski.maciej.vote.app.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class VoterInfoRepository {
    private final EntityManager entityManager;
    public List getInfoAboutAllVoters() {
        Query query = entityManager.createNativeQuery("SELECT v.id, v.name, COUNT(ev.id) FROM _voters v\n" +
                "LEFT JOIN _election_votes ev \n" +
                "ON v.id = ev.voter_id\n" +
                "GROUP BY v.id\n" +
                "ORDER BY v.id");
        return query.getResultList();
    }
}
