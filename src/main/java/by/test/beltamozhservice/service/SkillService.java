package by.test.beltamozhservice.service;

import by.test.beltamozhservice.dto.request.SkillRequest;
import by.test.beltamozhservice.dto.response.SkillResponse;
import by.test.beltamozhservice.entity.Skill;
import by.test.beltamozhservice.mapper.SkillMapper;
import by.test.beltamozhservice.repository.SkillRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    public SkillResponse findById(Long id) {
        return skillMapper.entityToDto(getEntityById(id));
    }

    public List<SkillResponse> findAll() {
        return skillRepository.findAll()
            .stream()
            .map(skillMapper::entityToDto)
            .toList();
    }

    public SkillResponse create(SkillRequest skillRequest) {
        Skill skill = skillMapper.dtoToEntity(skillRequest);
        skillRepository.save(skill);
        return skillMapper.entityToDto(skill);
    }

    public SkillResponse update(Long id, SkillRequest skillRequest) {
        Skill oldSkill = getEntityById(id);
        Skill skill = skillMapper.updateRequestToEntity(skillRequest, oldSkill);
        skillRepository.save(skill);
        return skillMapper.entityToDto(skill);
    }

    public void delete(Long id) {
        skillRepository.delete(getEntityById(id));
    }

    private Skill getEntityById(Long id) {
        return skillRepository.findById(id)
            .orElseThrow();
    }
}
