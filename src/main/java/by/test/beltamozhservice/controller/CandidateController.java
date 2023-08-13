package by.test.beltamozhservice.controller;

import by.test.beltamozhservice.dto.request.CandidateRequest;
import by.test.beltamozhservice.dto.response.CandidateResponse;
import by.test.beltamozhservice.service.CandidateService;
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
@RequestMapping("/api/v1/candidates")
@Tag(name = "Candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @Operation(summary = "Get Candidate by ID")
    @GetMapping("/{candidateId}")
    public ResponseEntity<CandidateResponse> getById(@PathVariable Long candidateId) {
        return ResponseEntity.ok(candidateService.findById(candidateId));
    }

    @Operation(summary = "Get all Candidates")
    @GetMapping
    public ResponseEntity<List<CandidateResponse>> getAllCandidates() {
        return ResponseEntity.ok(candidateService.findAll());
    }

    @Operation(summary = "Create new Candidate")
    @PostMapping
    public ResponseEntity<CandidateResponse> create(@RequestBody CandidateRequest candidateRequest) {
        return ResponseEntity.ok(candidateService.create(candidateRequest));
    }

    @Operation(summary = "Update Candidate by ID")
    @PutMapping("/{candidateId}")
    public ResponseEntity<CandidateResponse> update(@PathVariable Long candidateId,
        @RequestBody CandidateRequest candidateRequest) {
        return ResponseEntity.ok(candidateService.update(candidateId, candidateRequest));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete Candidate by ID")
    @DeleteMapping("/{candidateId}")
    public void delete(@PathVariable Long candidateId) {
        candidateService.delete(candidateId);
    }
}
