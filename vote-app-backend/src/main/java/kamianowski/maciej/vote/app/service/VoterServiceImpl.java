package kamianowski.maciej.vote.app.service;

import kamianowski.maciej.vote.app.mapper.VoterMapper;
import kamianowski.maciej.vote.app.model.Voter;
import kamianowski.maciej.vote.app.payload.VoterPayload;
import kamianowski.maciej.vote.app.repository.VoterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VoterServiceImpl implements VoterService{
    final private VoterRepository voterRepository;
    @Override
    public VoterPayload getVoterByName(String name) {
        Voter voter = voterRepository
                .findByName(name)
                .orElseThrow(() -> new RuntimeException("Voter: " + name + " nor found!"));
        return VoterMapper.mapToPayload(voter);
    }

    @Override
    public void addOrUpdateVoter(VoterPayload payload) {
        voterRepository.save(VoterMapper.mapToModel(payload));
    }

    @Override
    public void deleteVoter(VoterPayload payload) {
        voterRepository.delete(VoterMapper.mapToModel(payload));
    }

    @Override
    public List<VoterPayload> getAllVoters() {
        return voterRepository
                .getAllVotersSorted()
                .stream()
                .map(VoterMapper::mapToPayload)
                .collect(Collectors.toList());
    }
}
