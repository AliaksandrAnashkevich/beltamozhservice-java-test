package by.test.beltamozhservice.mapper;

import by.test.beltamozhservice.dto.request.SkillRequest;
import by.test.beltamozhservice.dto.response.SkillResponse;
import by.test.beltamozhservice.entity.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    SkillResponse entityToDto(Skill skill);

    Skill dtoToEntity(SkillRequest skillRequest);

    Skill updateRequestToEntity(SkillRequest skillRequest, @MappingTarget Skill skill);
}
