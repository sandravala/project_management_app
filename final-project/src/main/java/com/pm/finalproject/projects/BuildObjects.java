package com.pm.finalproject.projects;

import com.pm.finalproject.projects.model.Investment;
import com.pm.finalproject.projects.model.InvestmentDto;
import com.pm.finalproject.projects.model.Project;
import com.pm.finalproject.projects.model.ProjectDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BuildObjects {

    private final ProjectRepository projectRepository;
    private final InvestmentRepository investmentRepository;

    public Project saveProject(ProjectDto projectDto) {

        return Project.builder()
                .id(projectDto.getId())
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
                .build();
    }

    public Investment saveInvestment(InvestmentDto iDto, Long projectId) {
        return Investment.builder()
                .id(iDto.getId())
                .procurementType(iDto.getProcurementType())
                .name(iDto.getName())
                .plannedCostAmount(iDto.getPlannedCostAmount())
                .actualContractCosts(iDto.getActualContractCosts())
                .fundingRate(iDto.getFundingRate())
                .fundingAmount(iDto.getFundingAmount())
                .procurementDeadline(iDto.getProcurementDeadline())
                .procurementState(iDto.getProcurementState())
                .project(projectRepository.findById(projectId).get())
                .build();
    }





}
