package com.pm.finalproject.investment;

import com.pm.finalproject.investment.model.Investment;
import com.pm.finalproject.investment.model.InvestmentDto;
import com.pm.finalproject.projects.model.Project;
import com.pm.finalproject.projects.model.ProjectDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvestmentService {

    private final InvestmentRepository investmentRepository;

//    public List<InvestmentDto> getAllByProjectId(Long id) {
//        return mapToDto(investmentRepository.getAllByProjectId(id).stream().toList());
//    }
//
//    private List<InvestmentDto> mapToDto(Collection<Investment> entities) {
//        return entities.stream()
//                .map(o -> InvestmentDto.builder()
//                        .id(o.getId())
//                        .procurementType(o.getProcurementType())
//                        .name(o.getName())
//                        .plannedCostAmount(o.getPlannedCostAmount())
//                        .actualContractCosts(o.getActualContractCosts())
//                        .fundingRate(o.getFundingRate())
//                        .fundingAmount(o.getFundingAmount())
//                        .procurementDeadline(o.getProcurementDeadline())
//                        .procurementState(o.getProcurementState())
//                        .build())
//                .collect(Collectors.toList());
//    }


}
