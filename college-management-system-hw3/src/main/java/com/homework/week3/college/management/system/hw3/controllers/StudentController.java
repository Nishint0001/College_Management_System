package com.homework.week3.college.management.system.hw3.controllers;

import com.homework.week3.college.management.system.hw3.dtos.StudentDto;
import com.homework.week3.college.management.system.hw3.services.StudentService;
import org.springframework.core.codec.StringDecoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sc")
public class StudentController
{

    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseBody
    public StudentDto createStudent(@RequestBody StudentDto inputData)
    {
        return studentService.createNewStudent(inputData);
    }

    @GetMapping("/{id}")
    public StudentDto getById(Long id)
    {
        return studentService.getStudentById(id);
    }

    @GetMapping("/all")
    public List<StudentDto> getAll()
    {
        return studentService.getAllStudents();
    }

    @PutMapping
    public StudentDto update(Long id,StudentDto studentDto)
    {
        return studentService.updateStudentById(id,studentDto);
    }

    @DeleteMapping("/{id}")
    public String delete(Long id)
    {
        return studentService.deleteDataById(id);
    }

    @DeleteMapping
    public String deleteAll()
    {
        return studentService.deleteAll();
    }
}
