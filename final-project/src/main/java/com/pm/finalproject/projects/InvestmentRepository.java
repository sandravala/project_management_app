package com.pm.finalproject.projects;

import com.pm.finalproject.projects.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

    @Query(value = "SELECT i FROM Investment i WHERE i.project.id = :projectId")
    List<Investment> getAllByProjectId(@Param("projectId") Long id);

}
