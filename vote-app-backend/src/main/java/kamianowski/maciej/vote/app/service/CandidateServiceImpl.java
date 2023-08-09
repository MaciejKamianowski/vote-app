package kamianowski.maciej.vote.app.service;

import kamianowski.maciej.vote.app.mapper.CandidateMapper;
import kamianowski.maciej.vote.app.model.Candidate;
import kamianowski.maciej.vote.app.payload.CandidatePayload;
import kamianowski.maciej.vote.app.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService{
    final private CandidateRepository candidateRepository;
    @Override
    public CandidatePayload getCandidateByName(String name) {
        Candidate candidate = candidateRepository
                .findByName(name)
                .orElseThrow(() -> new RuntimeException("Candidate: " + name + " nor found!"));
        return CandidateMapper.mapToPayload(candidate);
    }

    @Override
    public void addOrUpdateCandidate(CandidatePayload payload) {
        candidateRepository.save(CandidateMapper.mapToModel(payload));
    }

    @Override
    public void deleteCandidate(CandidatePayload payload) {
        candidateRepository.delete(CandidateMapper.mapToModel(payload));
    }

    @Override
    public List<CandidatePayload> getAllCandidates() {
        return candidateRepository
                .findAll()
                .stream()
                .map(CandidateMapper::mapToPayload)
                .collect(Collectors.toList());
    }
}
