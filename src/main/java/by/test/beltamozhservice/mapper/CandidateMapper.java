package by.test.beltamozhservice.mapper;

import by.test.beltamozhservice.dto.request.CandidateRequest;
import by.test.beltamozhservice.dto.response.CandidateResponse;
import by.test.beltamozhservice.entity.Candidate;
import by.test.beltamozhservice.entity.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = SkillMapper.class)
public interface CandidateMapper {

    CandidateResponse entityToDto(Candidate candidate);

    Candidate dtoToEntity(CandidateRequest candidateRequest);

    Candidate updateRequestToEntity(CandidateRequest candidateRequest, @MappingTarget Candidate candidate);
}
