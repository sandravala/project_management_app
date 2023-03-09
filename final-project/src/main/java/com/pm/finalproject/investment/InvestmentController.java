package com.pm.finalproject.investment;

import com.pm.finalproject.investment.model.InvestmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/investment")
@CrossOrigin("*")
public class InvestmentController {

    private final InvestmentService investmentService;

//    @GetMapping("/{projectId}")
//    public List<InvestmentDto> getAllByProjectId(@PathVariable Long id) {
//        return investmentService.getAllByProjectId(id);
//    }

}
