package kamianowski.maciej.vote.app.service;

import kamianowski.maciej.vote.app.mapper.CandidateMapper;
import kamianowski.maciej.vote.app.model.Candidate;
import kamianowski.maciej.vote.app.payload.CandidateInfoPayload;
import kamianowski.maciej.vote.app.payload.CandidatePayload;
import kamianowski.maciej.vote.app.repository.CandidateInfoRepository;
import kamianowski.maciej.vote.app.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService{
    final private CandidateRepository candidateRepository;
    final private CandidateInfoRepository candidateInfoRepository;
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

    @Override
    public List<CandidateInfoPayload> getAllCandidateInfo() {
        List<Object[]> infoAboutAllCandidates = candidateInfoRepository.getInfoAboutAllCandidates();
        return infoAboutAllCandidates
                .stream()
                .map(info -> new CandidateInfoPayload((Long)info[0], info[1].toString(), (Long)info[2]))
                .collect(Collectors.toList());
    }
}


