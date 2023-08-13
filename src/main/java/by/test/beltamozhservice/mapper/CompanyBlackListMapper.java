package by.test.beltamozhservice.mapper;

import by.test.beltamozhservice.dto.response.CompanyBlackListResponse;
import by.test.beltamozhservice.entity.CompanyBlackList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyBlackListMapper {

    CompanyBlackListResponse entityToDto(CompanyBlackList companyBlackList);
}
