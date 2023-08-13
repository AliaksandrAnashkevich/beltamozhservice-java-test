package by.test.beltamozhservice.repository;

import by.test.beltamozhservice.entity.CompanyBlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyBlackListRepository extends JpaRepository<CompanyBlackList, Long> {
}