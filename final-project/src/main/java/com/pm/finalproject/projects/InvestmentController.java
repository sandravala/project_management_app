package com.pm.finalproject.projects;

import com.pm.finalproject.projects.InvestmentService;
import com.pm.finalproject.projects.model.InvestmentDto;
import com.pm.finalproject.projects.model.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
@CrossOrigin("*")
public class InvestmentController {

    private final InvestmentService investmentService;
    private final MapToDtos mapToDtos;

    //admin, pm, client
    @GetMapping("/{projectId}/iList")
    public List<InvestmentDto> getAllByProjectId(@PathVariable Long projectId) {
        return investmentService.getAllByProjectId(projectId);
    }

    //admin, pm
    @PostMapping("/{projectId}/iList")
    public InvestmentDto saveInvestment(@PathVariable Long projectId,
            @RequestBody InvestmentDto investmentDto) {
        return mapToDtos.investmentToDto(investmentService.saveInvestment(investmentDto, projectId));
    }

    //admin, pm
    @DeleteMapping("/iList")
    public String deleteInvestmentById(@RequestParam Long id) {
        return investmentService.deleteInvestmentById(id);
    }

}
