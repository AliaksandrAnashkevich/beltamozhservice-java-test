package by.test.beltamozhservice.dto.request;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateRequest {

    private String firstName;
    private String lastName;
    private String fartherName;
    private String jobTitle;
    private String lastJob;
    private String grade;
    private BigDecimal desiredSalary;
    private String description;
    private List<Long> skillsListId;
}
