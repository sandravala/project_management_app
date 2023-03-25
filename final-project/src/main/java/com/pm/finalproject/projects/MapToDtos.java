package com.pm.finalproject.projects;

import com.pm.finalproject.projects.model.Investment;
import com.pm.finalproject.projects.model.InvestmentDto;
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
public class MapToDtos {

    public List<ProjectDto> projectListToDto(Collection<Project> entities) {
        return entities.stream()
                .map(o -> ProjectDto.builder()
                        .id(o.getId())
                        .projectNo(o.getProjectNo())
                        .name(o.getName())
                        .client(o.getClient())
                        .coordinator(o.getCoordinator())
                        .projectAlias(o.getProjectAlias())
                        .startDate(o.getStartDate())
                        .endDate(o.getEndDate())
                        .contractSigningDate(o.getContractSigningDate())
                        .eligibleCosts(o.getEligibleCosts())
                        .fundingRate(o.getFundingRate())
                        .grantAmount(o.getGrantAmount())
                        .indirectCostRate(o.getIndirectCostRate())
                        .investmentDtos(investmentListToDto(o.getInvestments()))
                        .build())
                .collect(Collectors.toList());
    }

    public ProjectDto projectToDto(Project p) {
        return ProjectDto.builder()
                        .id(p.getId())
                        .projectNo(p.getProjectNo())
                        .name(p.getName())
                        .client(p.getClient())
                        .coordinator(p.getCoordinator())
                        .projectAlias(p.getProjectAlias())
                        .startDate(p.getStartDate())
                        .endDate(p.getEndDate())
                        .contractSigningDate(p.getContractSigningDate())
                        .eligibleCosts(p.getEligibleCosts())
                        .fundingRate(p.getFundingRate())
                        .grantAmount(p.getGrantAmount())
                        .indirectCostRate(p.getIndirectCostRate())
                        .investmentDtos(investmentListToDto(p.getInvestments()))
                        .build();
    }


    public List<InvestmentDto> investmentListToDto(Collection<Investment> entities) {
        return entities.stream()
                .map(o -> investmentToDto(o))
                .collect(Collectors.toList());
    }


    public InvestmentDto investmentToDto(Investment i) {
        return InvestmentDto.builder()
                        .id(i.getId())
                        .procurementType(i.getProcurementType())
                        .name(i.getName())
                        .plannedCostAmount(i.getPlannedCostAmount())
                        .actualContractCosts(i.getActualContractCosts())
                        .fundingRate(i.getFundingRate())
                        .fundingAmount(i.getFundingAmount())
                        .procurementDeadline(i.getProcurementDeadline())
                        .procurementState(i.getProcurementState())
                        .projectId(i.getProject().getId())
                        .build();
    }
}
