package by.test.beltamozhservice.service;

import by.test.beltamozhservice.dto.request.CandidateRequest;
import by.test.beltamozhservice.dto.response.CandidateResponse;
import by.test.beltamozhservice.entity.Candidate;
import by.test.beltamozhservice.mapper.CandidateMapper;
import by.test.beltamozhservice.repository.CandidateRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final CandidateMapper candidateMapper;

    public CandidateResponse findById(Long id) {
        return candidateMapper.entityToDto(getEntityById(id));
    }

    public List<CandidateResponse> findAll() {
        return candidateRepository.findAll()
            .stream()
            .map(candidateMapper::entityToDto)
            .toList();
    }

    public CandidateResponse create(CandidateRequest candidateRequest) {
        Candidate candidate = candidateMapper.dtoToEntity(candidateRequest);
        candidateRepository.save(candidate);
        return candidateMapper.entityToDto(candidate);
    }

    public CandidateResponse update(Long id, CandidateRequest candidateRequest) {
        Candidate oldCandidate = getEntityById(id);
        Candidate candidate = candidateMapper.updateRequestToEntity(candidateRequest, oldCandidate);
        candidateRepository.save(candidate);
        return candidateMapper.entityToDto(candidate);
    }

    public void delete(Long id) {
        candidateRepository.delete(getEntityById(id));
    }

    private Candidate getEntityById(Long id) {
        return candidateRepository.findById(id)
            .orElseThrow();
    }
}
