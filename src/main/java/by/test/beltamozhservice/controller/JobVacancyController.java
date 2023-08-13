package by.test.beltamozhservice.controller;

import by.test.beltamozhservice.dto.request.JobVacancyRequest;
import by.test.beltamozhservice.dto.response.JobVacancyResponse;
import by.test.beltamozhservice.service.JobVacancyService;
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
@RequestMapping("/api/v1/jobVacancy")
@Tag(name = "Job Vacancy")
@RequiredArgsConstructor
public class JobVacancyController {

    private final JobVacancyService jobVacancyService;

    @Operation(summary = "Get Job Vacancy by ID")
    @GetMapping("/{jobVacancyId}")
    public ResponseEntity<JobVacancyResponse> getOrderById(@PathVariable Long jobVacancyId) {
        return ResponseEntity.ok(jobVacancyService.findById(jobVacancyId));
    }

    @Operation(summary = "Get all Job Vacancies")
    @GetMapping
    public ResponseEntity<List<JobVacancyResponse>> getAllOrders() {
        return ResponseEntity.ok(jobVacancyService.findAll());
    }

    @Operation(summary = "Create new Job Vacancy")
    @PostMapping
    public ResponseEntity<JobVacancyResponse> create(@RequestBody JobVacancyRequest jobVacancyRequest) {
        return ResponseEntity.ok(jobVacancyService.create(jobVacancyRequest));
    }

    @Operation(summary = "Update Job Vacancy by ID")
    @PutMapping("/{jobVacancyId}")
    public ResponseEntity<JobVacancyResponse> update(@PathVariable Long jobVacancyId,
        @RequestBody JobVacancyRequest jobVacancyRequest) {
        return ResponseEntity.ok(jobVacancyService.update(jobVacancyId, jobVacancyRequest));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Get Job Vacancy by ID")
    @DeleteMapping("/{jobVacancyId}")
    public void delete(@PathVariable Long jobVacancyId) {
        jobVacancyService.delete(jobVacancyId);
    }
}
