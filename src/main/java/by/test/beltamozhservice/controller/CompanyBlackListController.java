package by.test.beltamozhservice.controller;

import by.test.beltamozhservice.dto.response.CandidateBlackListResponse;
import by.test.beltamozhservice.dto.response.CompanyBlackListResponse;
import by.test.beltamozhservice.service.CompanyBlackListService;
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
@RequestMapping("/api/v1/companiesBlacklist")
@Tag(name = "Candidates")
@RequiredArgsConstructor
public class CompanyBlackListController {

    private final CompanyBlackListService companyBlackListService;

    @Operation(summary = "Get Blacklist of Companies")
    @GetMapping
    public ResponseEntity<List<CompanyBlackListResponse>> getAllItems() {
        return ResponseEntity.ok(companyBlackListService.findAll());
    }

    @Operation(summary = "Get Company from Blacklist by ID")
    @GetMapping("/{blacklistCompaniesId}")
    public ResponseEntity<CompanyBlackListResponse> getItemById(@PathVariable Long blacklistCompaniesId) {
        return ResponseEntity.ok(companyBlackListService.findById(blacklistCompaniesId));
    }
}
