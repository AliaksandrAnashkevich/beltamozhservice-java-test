package by.test.beltamozhservice.repository;

import by.test.beltamozhservice.entity.CandidateBlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateBlackListRepository extends JpaRepository<CandidateBlackList, Long> {
}