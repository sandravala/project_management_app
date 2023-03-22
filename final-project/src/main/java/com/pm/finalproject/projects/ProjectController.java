package com.pm.finalproject.projects;


import com.pm.finalproject.projects.model.Project;
import com.pm.finalproject.projects.model.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
@CrossOrigin("*")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/all")
    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Optional<ProjectDto> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping("/save")
    public Project createProject(@RequestBody ProjectDto projectDto) {

        return projectService.saveProject(projectDto);
    }

}
