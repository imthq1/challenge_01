package com.example.demo.Controller;

import com.example.demo.Domain.SumRequest;
import com.example.demo.Domain.SumResult;
import com.example.demo.Service.SumService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class SumController {
    private final SumService sumService;

    public SumController(SumService sumService) {
        this.sumService = sumService;
    }

    @PostMapping("/sum")
    public SumResult calculateSum(@RequestBody SumRequest request) {
        return sumService.sum(request.getNumber1(), request.getNumber2());
    }
}
