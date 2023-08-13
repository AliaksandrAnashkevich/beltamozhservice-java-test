package by.test.beltamozhservice.service;

import by.test.beltamozhservice.dto.response.CandidateBlackListResponse;
import by.test.beltamozhservice.entity.CandidateBlackList;
import by.test.beltamozhservice.mapper.CandidateBlackListMapper;
import by.test.beltamozhservice.repository.CandidateBlackListRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateBlackListService {

    private final CandidateBlackListRepository companyBlackListRepository;
    private final CandidateBlackListMapper companyBlackListMapper;

    public CandidateBlackListResponse findById(Long id) {
        return companyBlackListMapper.entityToDto(getEntityById(id));
    }

    public List<CandidateBlackListResponse> findAll() {
        return companyBlackListRepository.findAll()
            .stream()
            .map(companyBlackListMapper::entityToDto)
            .toList();
    }

    private CandidateBlackList getEntityById(Long id) {
        return companyBlackListRepository.findById(id)
            .orElseThrow();
    }
}
