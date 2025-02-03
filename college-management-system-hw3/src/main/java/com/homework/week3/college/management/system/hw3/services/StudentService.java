package com.homework.week3.college.management.system.hw3.services;

import com.homework.week3.college.management.system.hw3.dtos.StudentDto;
import com.homework.week3.college.management.system.hw3.entities.Student;
import com.homework.week3.college.management.system.hw3.repositories.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    public StudentService(StudentRepo studentRepo, ModelMapper modelMapper)
    {
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }

    //create

    public StudentDto createNewStudent(StudentDto input)
    {
        Student convertToEntityFirst=modelMapper.map(input, Student.class);

        Student saved=studentRepo.save(convertToEntityFirst);

        StudentDto convertBackToDto=modelMapper.map(saved, StudentDto.class);

        return convertBackToDto;
    }

    // get

    public StudentDto getStudentById(Long id)
    {
        Student getFromDB=studentRepo.findById(id).orElse(null);

        StudentDto convertToDto=modelMapper.map(getFromDB, StudentDto.class);

        return convertToDto;
    }

    // get All

    public List<StudentDto> getAllStudents()
    {

        List<Student> getAllFromDB=studentRepo.findAll();

        List<StudentDto> convertToDtoList=getAllFromDB.stream().map(record->modelMapper.map(record, StudentDto.class)).toList();

        return  convertToDtoList;
    }

    //update
    public StudentDto updateStudentById(Long id,StudentDto updatedData)
    {
        Student findThatFromDB=studentRepo.findById(id).orElse(null);

        modelMapper.map(updatedData, findThatFromDB);

        StudentDto backToDto=modelMapper.map(findThatFromDB, StudentDto.class);

        return backToDto;

    }

    //delete

    public String deleteDataById(Long id)
    {
        if(studentRepo.findById(id).isPresent())
        {
            studentRepo.deleteById(id);
            return "DATA DELETED FROM DATABASE";
        }
        return "RECORD NOT PRESENT IN DATABASE";
    }

    //DELETE ALL

    public String deleteAll()
    {
        if(studentRepo.findAll().isEmpty()==false)
        {
            studentRepo.deleteAll();
            return "ALL RECORDS DELETEd";
        }
        return "EMPTY DATABSE";
    }


}
