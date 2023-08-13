package by.test.beltamozhservice.service;

import by.test.beltamozhservice.dto.request.JobVacancyRequest;
import by.test.beltamozhservice.dto.response.JobVacancyResponse;
import by.test.beltamozhservice.entity.JobVacancy;
import by.test.beltamozhservice.mapper.JobVacancyMapper;
import by.test.beltamozhservice.repository.JobVacancyRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobVacancyService {

    private final JobVacancyRepository jobVacancyRepository;
    private final JobVacancyMapper jobVacancyMapper;

    public JobVacancyResponse findById(Long id) {
        return jobVacancyMapper.entityToDto(getEntityById(id));
    }

    public List<JobVacancyResponse> findAll() {
        return jobVacancyRepository.findAll()
            .stream()
            .map(jobVacancyMapper::entityToDto)
            .toList();
    }

    public JobVacancyResponse create(JobVacancyRequest jobVacancyRequest) {
        JobVacancy jobVacancy = jobVacancyMapper.dtoToEntity(jobVacancyRequest);
        jobVacancyRepository.save(jobVacancy);
        return jobVacancyMapper.entityToDto(jobVacancy);
    }

    public JobVacancyResponse update(Long id, JobVacancyRequest jobVacancyRequest) {
        JobVacancy oldJobVacancy = getEntityById(id);
        JobVacancy jobVacancy = jobVacancyMapper.updateRequestToEntity(jobVacancyRequest, oldJobVacancy);
        jobVacancyRepository.save(jobVacancy);
        return jobVacancyMapper.entityToDto(jobVacancy);
    }

    public void delete(Long id) {
        jobVacancyRepository.delete(getEntityById(id));
    }

    private JobVacancy getEntityById(Long id) {
        return jobVacancyRepository.findById(id)
            .orElseThrow();
    }
}
