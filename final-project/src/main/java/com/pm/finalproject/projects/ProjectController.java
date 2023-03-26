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
    private final MapToDtos mapToDtos;

    @GetMapping("/all")
    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Optional<ProjectDto> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @DeleteMapping
    public String deleteProjectById(@RequestParam Long id) {
        return projectService.deleteProjectById(id);
    }

    @PostMapping("/save")
    public ProjectDto createProject(@RequestBody ProjectDto projectDto) {
        projectService.saveProject(projectDto);
        return mapToDtos.projectToDto(projectService.saveProject(projectDto));
    }

}
