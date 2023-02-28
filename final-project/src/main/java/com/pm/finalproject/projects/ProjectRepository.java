package com.pm.finalproject.projects;

import com.pm.finalproject.projects.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value="SELECT * FROM PROJECT", nativeQuery = true, countQuery = "SELECT count(*) FROM PROJECT")
    List<Project> getAllProjects();
}