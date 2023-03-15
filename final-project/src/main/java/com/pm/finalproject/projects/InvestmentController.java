package com.pm.finalproject.projects;

import com.pm.finalproject.projects.InvestmentService;
import com.pm.finalproject.projects.model.InvestmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
@CrossOrigin("*")
public class InvestmentController {

    private final InvestmentService investmentService;

    @GetMapping("/{projectId}/iList")
    public List<InvestmentDto> getAllByProjectId(@PathVariable Long projectId) {
        return investmentService.getAllByProjectId(projectId);
    }

}
