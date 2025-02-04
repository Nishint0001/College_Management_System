package com.homework.week3.college.management.system.hw3.services;

import com.homework.week3.college.management.system.hw3.dtos.SubjectDto;
import com.homework.week3.college.management.system.hw3.dtos.SubjectDto;
import com.homework.week3.college.management.system.hw3.entities.Subject;
import com.homework.week3.college.management.system.hw3.repositories.StudentRepo;
import com.homework.week3.college.management.system.hw3.repositories.SubjectRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubjectService
{
    private final SubjectRepo subjectRepo;
    private final ModelMapper modelMapper;

    public SubjectService(SubjectRepo subjectRepo, ModelMapper modelMapper)
    {
        this.subjectRepo = subjectRepo;
        this.modelMapper = modelMapper;
    }

    //create

    public SubjectDto createNewStudent(SubjectDto input)
    {
        Subject convertToEntityFirst=modelMapper.map(input, Subject.class);

        Subject saved=subjectRepo.save(convertToEntityFirst);

        SubjectDto convertBackToDto=modelMapper.map(saved, SubjectDto.class);

        return convertBackToDto;
    }

    // get

    public SubjectDto getStudentById(Long id)
    {
        Subject getFromDB=subjectRepo.findById(id).orElse(null);

        SubjectDto convertToDto=modelMapper.map(getFromDB, SubjectDto.class);

        return convertToDto;
    }

    // get All

    public List<SubjectDto> getAllStudents()
    {
        List<Subject> getAllFromDB=subjectRepo.findAll();

        List<SubjectDto> convertToDtoList=getAllFromDB.stream().map(record->modelMapper.map(record, SubjectDto.class)).toList();

        return  convertToDtoList;
    }

    //update
    public SubjectDto updateStudentById(Long id,SubjectDto updatedData)
    {
        Subject findThatFromDB=subjectRepo.findById(id).orElse(null);

        modelMapper.map(updatedData, findThatFromDB);

        SubjectDto backToDto=modelMapper.map(findThatFromDB, SubjectDto.class);

        return backToDto;

    }

    //delete

    public String deleteDataById(Long id)
    {
        if(subjectRepo.findById(id).isPresent())
        {
            subjectRepo.deleteById(id);
            return "DATA DELETED FROM DATABASE";
        }
        return "RECORD NOT PRESENT IN DATABASE";
    }

    //DELETE ALL

    public String deleteAll()
    {
        if(subjectRepo.findAll().isEmpty()==false)
        {
            subjectRepo.deleteAll();
            return "ALL RECORDS DELETEd";
        }
        return "EMPTY DATABSE";
    }
}



