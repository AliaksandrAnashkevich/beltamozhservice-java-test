package by.test.beltamozhservice.mapper;

import by.test.beltamozhservice.dto.response.CandidateBlackListResponse;
import by.test.beltamozhservice.entity.CandidateBlackList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidateBlackListMapper {

    CandidateBlackListResponse entityToDto(CandidateBlackList candidateBlackList);
}
