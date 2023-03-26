package com.pm.finalproject.projects;

import com.pm.finalproject.projects.model.Investment;
import com.pm.finalproject.projects.model.InvestmentDto;
import com.pm.finalproject.projects.model.Project;
import com.pm.finalproject.projects.model.ProjectDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final MapToDtos mapToDtos;
    private final BuildObjects buildObjects;

    public List<ProjectDto> getAllProjects() {
        return mapToDtos.projectListToDto(projectRepository.getAllProjects());
    }

    public Optional<ProjectDto> getProjectById(Long id) {
        return mapToDtos.projectListToDto(projectRepository.findById(id).stream().toList())
               .stream()
               .findFirst();
    }

    public Project saveProject(ProjectDto projectDto) {
        Project projectToSave = buildObjects.saveProject(projectDto);
        boolean isNewProject = projectToSave.getId() == null;
        if (!isNewProject) {
            projectToSave.addInvestments(projectRepository.getReferenceById(projectToSave.getId()).getInvestments());
        } else {
            projectToSave.addInvestments(new ArrayList<>());
        }
        return projectRepository.save(projectToSave);
    }


    public String deleteProjectById(Long id) {
        String before = "size before: " + projectRepository.getAllProjects().size() + ", size after: ";
        projectRepository.deleteById(id);
        return before + projectRepository.getAllProjects().size();
    }
}