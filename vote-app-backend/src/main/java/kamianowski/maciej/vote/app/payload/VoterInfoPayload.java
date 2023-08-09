package kamianowski.maciej.vote.app.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoterInfoPayload {
    private Long id;
    private String name;
    private Boolean hasVoted;
}
