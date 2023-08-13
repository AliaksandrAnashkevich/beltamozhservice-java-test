package by.test.beltamozhservice.mapper;

import by.test.beltamozhservice.dto.request.JobVacancyRequest;
import by.test.beltamozhservice.dto.response.JobVacancyResponse;
import by.test.beltamozhservice.entity.JobVacancy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {SkillMapper.class, CandidateMapper.class})
public interface JobVacancyMapper {

    JobVacancyResponse entityToDto(JobVacancy jobVacancy);

    JobVacancy dtoToEntity(JobVacancyRequest jobVacancyRequest);

    JobVacancy updateRequestToEntity(JobVacancyRequest jobVacancyRequest, @MappingTarget JobVacancy jobVacancy);
}
