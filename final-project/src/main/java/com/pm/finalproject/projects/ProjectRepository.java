package com.pm.finalproject.projects;

import com.pm.finalproject.projects.model.Project;
import com.pm.finalproject.projects.model.ProjectDto;
import com.pm.finalproject.users.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "SELECT p FROM Project p ORDER BY p.projectAlias ASC")
    List<Project> getAllProjects();

    @Query(value= "SELECT p FROM Project p WHERE p.coordinator = :email ORDER BY p.projectAlias ASC")
    List<Project> getProjectsByCoordinator(@Param("email") String email);


}