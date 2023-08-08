package kamianowski.maciej.vote.app.rest;

import kamianowski.maciej.vote.app.payload.VoterPayload;
import kamianowski.maciej.vote.app.service.VoterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voters")
@RequiredArgsConstructor
public class VoterController {

    final private VoterService voterService;
    @PostMapping("/new")
    public ResponseEntity<String> addNewVoter(@RequestBody VoterPayload payload) {
        voterService.addOrUpdateVoter(payload);
        return ResponseEntity.ok("The voter " + payload.getName() + " added successfully!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<VoterPayload>> getVoters() {
        return new ResponseEntity<>(voterService.getAllVoters(), HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateVoter(@RequestBody VoterPayload payload) {
        voterService.addOrUpdateVoter(payload);
        return ResponseEntity.ok("The voter with id: " + payload.getId() + " updated successfully!");

    }

    @PostMapping("/get")
    public ResponseEntity<?> getVoter(@RequestBody VoterPayload payload) {
        try {
            payload = voterService.getVoterByName(payload.getName());
        } catch (RuntimeException e) {
            return new ResponseEntity<String>("Voter not found!", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(payload);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteVoter(@RequestBody VoterPayload payload) {
        voterService.deleteVoter(payload);
        return ResponseEntity.ok("Voter with id " + payload.getId() + " deleted.");
    }
}
