package by.test.beltamozhservice.dto.response;


import by.test.beltamozhservice.entity.Skill;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class CandidateResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String fartherName;
    private String jobTitle;
    private String lastJob;
    private String grade;
    private BigDecimal desiredSalary;
    private String description;
    private List<SkillResponse> skills;
}
