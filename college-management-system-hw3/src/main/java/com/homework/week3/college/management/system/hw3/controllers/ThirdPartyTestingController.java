package com.homework.week3.college.management.system.hw3.controllers;

import com.homework.week3.college.management.system.hw3.dtos.ThirdPartyTestingEntityDto;
import com.homework.week3.college.management.system.hw3.services.ThirdPartyTestingService;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tptc")
public class ThirdPartyTestingController
{
    private final ThirdPartyTestingService thirdPartyTestingService;

    public ThirdPartyTestingController(ThirdPartyTestingService thirdPartyTestingService)
    {
        this.thirdPartyTestingService = thirdPartyTestingService;
    }

    @PostMapping("/create")
    public ThirdPartyTestingEntityDto post(@RequestBody ThirdPartyTestingEntityDto inputData)
    {
        return thirdPartyTestingService.createpost(inputData);
    }

    @GetMapping("/all")
    public List<ThirdPartyTestingEntityDto> getALl()
    {
        return thirdPartyTestingService.getAll();
    }
}
