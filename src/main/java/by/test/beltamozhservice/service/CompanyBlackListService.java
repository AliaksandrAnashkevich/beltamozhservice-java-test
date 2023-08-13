package by.test.beltamozhservice.service;

import by.test.beltamozhservice.dto.response.CompanyBlackListResponse;
import by.test.beltamozhservice.entity.CompanyBlackList;
import by.test.beltamozhservice.mapper.CompanyBlackListMapper;
import by.test.beltamozhservice.repository.CompanyBlackListRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyBlackListService {

    private final CompanyBlackListRepository companyBlackListRepository;
    private final CompanyBlackListMapper companyBlackListMapper;

    public CompanyBlackListResponse findById(Long id) {
        return companyBlackListMapper.entityToDto(getEntityById(id));
    }

    public List<CompanyBlackListResponse> findAll() {
        return companyBlackListRepository.findAll()
            .stream()
            .map(companyBlackListMapper::entityToDto)
            .toList();
    }

    private CompanyBlackList getEntityById(Long id) {
        return companyBlackListRepository.findById(id)
            .orElseThrow();
    }
}
