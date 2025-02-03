package com.homework.week3.college.management.system.hw3.controllers;

import com.homework.week3.college.management.system.hw3.dtos.AdmissionRecordDto;
import com.homework.week3.college.management.system.hw3.services.AdmissionRecordService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/arc")


@NoArgsConstructor(force = true)

@Getter
@Setter
public class AdmissionRecordController
{
    private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    //create

    @PostMapping
    @ResponseBody
    public AdmissionRecordDto createAdmissionRecord(@RequestBody AdmissionRecordDto inputData)
    {
        return admissionRecordService.createNewAdmission(inputData);
    }

    //get

    @GetMapping("/{id}")
    public AdmissionRecordDto getById(Long id)
    {
        return admissionRecordService.getAdmissionById(id);
    }

    //getAll

    @GetMapping(path ="/all")
    public List<AdmissionRecordDto> getAllAdmissionRecord()
    {
        return admissionRecordService.getAllAdmission();
    }

    //update
    @PutMapping("/{id}")
    public AdmissionRecordDto updateById(Long id,AdmissionRecordDto admissionRecordDto)
    {
        return admissionRecordService.updateAdmissionById(id, admissionRecordDto);
    }

    //delete

    @DeleteMapping("/{id}")
    public String deleteById(Long id)
    {
        return admissionRecordService.deleteById(id);
    }

    @DeleteMapping("/all")
    public String deleteAll()
    {
        return admissionRecordService.deleteAll();
    }

}
