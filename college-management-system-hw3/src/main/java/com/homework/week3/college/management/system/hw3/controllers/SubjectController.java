package com.homework.week3.college.management.system.hw3.controllers;

import com.homework.week3.college.management.system.hw3.dtos.SubjectDto;
import com.homework.week3.college.management.system.hw3.services.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sbc")
public class SubjectController
{
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService)
    {
        this.subjectService = subjectService;
    }

    @PostMapping
    @ResponseBody
    public SubjectDto createStudent(@RequestBody SubjectDto inputData)
    {
        return subjectService.createNewStudent(inputData);
    }

    @GetMapping("/{id}")
    public SubjectDto getById(Long id)
    {
        return subjectService.getStudentById(id);
    }

    @GetMapping("/all")
    public List<SubjectDto> getAll()
    {
        return subjectService.getAllStudents();
    }

    @PutMapping("/{id}")
    public SubjectDto update(Long id,SubjectDto studentDto)
    {
        return subjectService.updateStudentById(id,studentDto);
    }

    @DeleteMapping("/{id}")
    public String delete(Long id)
    {
        return subjectService.deleteDataById(id);
    }

    @DeleteMapping("/all")
    public String deleteAll()
    {
        return subjectService.deleteAll();
    }
}
