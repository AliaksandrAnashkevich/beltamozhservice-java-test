package by.test.beltamozhservice.controller;

import by.test.beltamozhservice.dto.request.SkillRequest;
import by.test.beltamozhservice.dto.response.SkillResponse;
import by.test.beltamozhservice.service.SkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/skills")
@Tag(name = "Skill")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @Operation(summary = "Get Skill by ID")
    @GetMapping("/{skillId}")
    public ResponseEntity<SkillResponse> getById(@PathVariable Long skillId) {
        return ResponseEntity.ok(skillService.findById(skillId));
    }

    @Operation(summary = "Get all Skills")
    @GetMapping
    public ResponseEntity<List<SkillResponse>> getAllSkills() {
        return ResponseEntity.ok(skillService.findAll());
    }

    @Operation(summary = "Create new Skill")
    @PostMapping
    public ResponseEntity<SkillResponse> create(@RequestBody SkillRequest skillRequest) {
        return ResponseEntity.ok(skillService.create(skillRequest));
    }

    @Operation(summary = "Update Skill by ID")
    @PutMapping("/{skillId}")
    public ResponseEntity<SkillResponse> update(@PathVariable Long skillId,
        @RequestBody SkillRequest skillRequest) {
        return ResponseEntity.ok(skillService.update(skillId, skillRequest));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Get Skill by ID")
    @DeleteMapping("/{skillId}")
    public void delete(@PathVariable Long skillId) {
        skillService.delete(skillId);
    }
}
