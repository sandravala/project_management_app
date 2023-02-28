package com.pm.finalproject.projects;

import com.pm.finalproject.projects.model.Project;
import com.pm.finalproject.projects.model.ProjectDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<ProjectDto> getAllProjects() {
        return mapToDto(projectRepository.getAllProjects());
    }

    private List<ProjectDto> mapToDto(Collection<Project> entities) {
        return entities.stream()
                .map(o -> ProjectDto.builder()
                        .id(o.getId())
                        .projectNo(o.getProjectNo())
                        .name(o.getName())
                        .client(o.getClient())
                        .coordinator(o.getCoordinator())
                        .alias(o.getAlias())
                        .startDate(o.getStartDate())
                        .endDate(o.getEndDate())
                        .contractSigningDate(o.getContractSigningDate())
                        .eligibleCosts(o.getEligibleCosts())
                        .fundingRate(o.getFundingRate())
                        .grantAmount(o.getGrantAmount())
                        .indirectCostRate(o.getIndirectCostRate())
                        .build())
                .collect(Collectors.toList());
    }

}