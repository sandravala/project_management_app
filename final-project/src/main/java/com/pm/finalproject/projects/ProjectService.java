package com.pm.finalproject.projects;

import com.pm.finalproject.projects.model.Investment;
import com.pm.finalproject.projects.model.InvestmentDto;
import com.pm.finalproject.projects.model.Project;
import com.pm.finalproject.projects.model.ProjectDto;
import com.pm.finalproject.users.UserRepository;
import com.pm.finalproject.users.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    private final UserRepository userRepository;

    public List<ProjectDto> getAllProjects() {
        return mapToDtos.projectListToDto(projectRepository.getAllProjects());
    }

    public Optional<ProjectDto> getProjectById(Long id) {
        return mapToDtos.projectListToDto(projectRepository.findById(id).stream().toList())
               .stream()
               .findFirst();
    }

    public List<ProjectDto> getProjectByCoordinator(Long id) {
        Boolean userExists = userRepository.existsById(id);
        List<ProjectDto> filteredList = userExists ? mapToDtos.projectListToDto(projectRepository.getProjectsByCoordinator(userRepository.getReferenceById(id).getEmail())) : new ArrayList<>();
        return filteredList;
    }

    public Project saveProject(ProjectDto projectDto) {
        Project projectToSave;
        boolean isNewProject = projectDto.getId() == null;
        if (!isNewProject) {
            Project projectToEdit = projectRepository.findById(projectDto.getId()).get();

            projectToEdit.setProjectNo(projectDto.getProjectNo());
            projectToEdit.setName(projectDto.getName());
            projectToEdit.setClient(projectDto.getClient());
            projectToEdit.setCoordinator(projectDto.getCoordinator());
            projectToEdit.setProjectAlias(projectDto.getProjectAlias());
            projectToEdit.setStartDate(projectDto.getStartDate());
            projectToEdit.setEndDate(projectDto.getEndDate());
            projectToEdit.setContractSigningDate(projectDto.getContractSigningDate());
            projectToEdit.setEligibleCosts(projectDto.getEligibleCosts());
            projectToEdit.setFundingRate(projectDto.getFundingRate());
            projectToEdit.setGrantAmount(projectDto.getGrantAmount());
            projectToEdit.setIndirectCostRate(projectDto.getIndirectCostRate());

            projectToEdit.addInvestments(projectRepository.getReferenceById(projectDto.getId()).getInvestments());
            projectToSave = projectToEdit;

        } else {
            projectToSave = buildObjects.saveProject(projectDto);
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