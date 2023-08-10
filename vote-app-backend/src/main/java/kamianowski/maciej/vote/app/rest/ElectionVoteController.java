package kamianowski.maciej.vote.app.rest;

import kamianowski.maciej.vote.app.payload.CandidatePayload;
import kamianowski.maciej.vote.app.payload.ElectionVotePayload;
import kamianowski.maciej.vote.app.service.ElectionVoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/elections")
@RequiredArgsConstructor
public class ElectionVoteController {
    final private ElectionVoteService electionVoteService;

    @PostMapping("/vote")
    public ResponseEntity<String> castTheVote(@RequestBody ElectionVotePayload payload) {
        try {
            electionVoteService.castVote(payload);
        } catch (RuntimeException e) {
            return new ResponseEntity<String>(e.getLocalizedMessage(), HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok("Vote casted!");
    }

    @GetMapping("/voted/{id}")
    public ResponseEntity<Boolean> checkIfVoterCastedElectionVote(@PathVariable Long id) {
        return ResponseEntity.ok(
                electionVoteService
                        .checkIfVoterCastedElectionVote(id));
    }

    @GetMapping("/candidate/{id}")
    public ResponseEntity<Long> getNUmberOfElectionVotesPerCandidate(@PathVariable Long id) {
        return ResponseEntity.ok(
                electionVoteService
                        .getNumberOfElectionVotesForCandidate(id));
    }
}
