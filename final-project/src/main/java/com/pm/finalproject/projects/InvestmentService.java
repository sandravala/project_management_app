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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final MapToDtos mapToDtos;
    private final BuildObjects buildObjects;
    private final ProjectRepository projectRepository;

    public List<InvestmentDto> getAllByProjectId(Long id) {
        return mapToDtos.investmentListToDto(investmentRepository.getAllByProjectId(id).stream().toList());
    }

    public Investment saveInvestment(InvestmentDto investmentDto, Long projectId) {
        Investment investmentToSave = buildObjects.saveInvestment(investmentDto, projectId);
        return investmentRepository.save(investmentToSave);
    }

    public String deleteInvestmentById(Long id) {
        String before = "size before: " + investmentRepository.findAll().size() + ", size after: ";
        investmentRepository.deleteById(id);
        return before + investmentRepository.findAll().size();
    }


}
