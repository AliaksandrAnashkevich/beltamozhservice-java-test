package by.test.beltamozhservice.controller;

import by.test.beltamozhservice.dto.response.CandidateBlackListResponse;
import by.test.beltamozhservice.service.CandidateBlackListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/candidatesBlacklist")
@Tag(name = "Candidates")
@RequiredArgsConstructor
public class CandidateBlackListController {

    private final CandidateBlackListService candidateBlackListService;

    @Operation(summary = "Get Blacklist of Candidates")
    @GetMapping
    public ResponseEntity<List<CandidateBlackListResponse>> getAllItems() {
        return ResponseEntity.ok(candidateBlackListService.findAll());
    }

    @Operation(summary = "Get Candidate from Blacklist by ID")
    @GetMapping("/{blacklistCandidatesId}")
    public ResponseEntity<CandidateBlackListResponse> getItemById(@PathVariable Long blacklistCandidatesId) {
        return ResponseEntity.ok(candidateBlackListService.findById(blacklistCandidatesId));
    }
}
