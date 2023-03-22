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

    public List<ProjectDto> projectToDto(Collection<Project> entities) {
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
                        .investmentDtos(investmentToDto(o.getInvestments()))
                        .build())
                .collect(Collectors.toList());
    }


    public List<InvestmentDto> investmentToDto(Collection<Investment> entities) {
        return entities.stream()
                .map(o -> InvestmentDto.builder()
                        .id(o.getId())
                        .procurementType(o.getProcurementType())
                        .name(o.getName())
                        .plannedCostAmount(o.getPlannedCostAmount())
                        .actualContractCosts(o.getActualContractCosts())
                        .fundingRate(o.getFundingRate())
                        .fundingAmount(o.getFundingAmount())
                        .procurementDeadline(o.getProcurementDeadline())
                        .procurementState(o.getProcurementState())
                        .projectId(o.getProject().getId())
                        .build())
                .collect(Collectors.toList());
    }

}
