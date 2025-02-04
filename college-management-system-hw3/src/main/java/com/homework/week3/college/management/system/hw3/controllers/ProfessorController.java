package com.homework.week3.college.management.system.hw3.controllers;

import com.homework.week3.college.management.system.hw3.dtos.ProfessorDto;
import com.homework.week3.college.management.system.hw3.services.ProfessorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pc")
public class ProfessorController
{
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService)
    {
        this.professorService = professorService;
    }

    @PostMapping
    public ProfessorDto createNewPost(ProfessorDto professorDto)
    {
        return professorService.createNewProfessor(professorDto);
    }

    @GetMapping("/all")
    public List<ProfessorDto> getAllProfessor()
    {
        return professorService.getAllProfessor();
    }

    @GetMapping("/{id}")
    public ProfessorDto getProfessor(Long id)
    {
        return professorService.getProfessorById(id);
    }

    @PutMapping("/id")
    public ProfessorDto updateProfessor(Long id,ProfessorDto input)
    {
        return professorService.updateById(id, input);
    }

    @DeleteMapping("/id")
    public String deleteById(Long id)
    {
        return professorService.deleteById(id);
    }

    @DeleteMapping("/all")
    public String deleteAll()
    {
        return professorService.deleteAll();
    }
}
