package kamianowski.maciej.vote.app.rest;

import kamianowski.maciej.vote.app.payload.CandidatePayload;
import kamianowski.maciej.vote.app.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/candidates")
@RequiredArgsConstructor
public class CandidateController {
    final private CandidateService candidateService;

    @PostMapping("/new")
    public ResponseEntity<String> addNewCandidate(@RequestBody CandidatePayload payload) {
        candidateService.addOrUpdateCandidate(payload);
        return ResponseEntity.ok("The candidate " + payload.getName() + " added successfully!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<CandidatePayload>> getCandidates() {
        return new ResponseEntity<>(candidateService.getAllCandidates(), HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateVoter(@RequestBody CandidatePayload payload) {
        candidateService.addOrUpdateCandidate(payload);
        return ResponseEntity.ok("The candidate with id: " + payload.getId() + " updated successfully!");

    }

    @PostMapping("/get")
    public ResponseEntity<?> getVoter(@RequestBody CandidatePayload payload) {
        try {
            payload = candidateService.getCandidateByName(payload.getName());
        } catch (RuntimeException e) {
            return new ResponseEntity<String>("Candidate not found!", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(payload);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteVoter(@RequestBody CandidatePayload payload) {
        candidateService.deleteCandidate(payload);
        return ResponseEntity.ok("Candidate with id " + payload.getId() + " deleted.");
    }
}
