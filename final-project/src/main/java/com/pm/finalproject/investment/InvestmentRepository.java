package com.pm.finalproject.investment;

import com.pm.finalproject.investment.model.Investment;
import com.pm.finalproject.projects.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

//    @Query(value = "SELECT p FROM Project p")
    List<Investment> getAllByProjectId(Long id);

}
