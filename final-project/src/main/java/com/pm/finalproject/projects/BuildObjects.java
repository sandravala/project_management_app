package com.pm.finalproject.projects;

import com.pm.finalproject.projects.model.InvestmentDto;
import com.pm.finalproject.projects.model.Project;
import com.pm.finalproject.projects.model.ProjectDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BuildObjects {

    public Project saveProject(ProjectDto projectDto) {
        return Project.builder()
                .projectNo(projectDto.getProjectNo())
                .name(projectDto.getName())
                .client(projectDto.getClient())
                .coordinator(projectDto.getCoordinator())
                .projectAlias(projectDto.getProjectAlias())
                .startDate(projectDto.getStartDate())
                .endDate(projectDto.getEndDate())
                .contractSigningDate(projectDto.getContractSigningDate())
                .eligibleCosts(projectDto.getEligibleCosts())
                .fundingRate(projectDto.getFundingRate())
                .grantAmount(projectDto.getGrantAmount())
                .indirectCostRate(projectDto.getIndirectCostRate())
                .investments(null)
                .build();
    }
}
