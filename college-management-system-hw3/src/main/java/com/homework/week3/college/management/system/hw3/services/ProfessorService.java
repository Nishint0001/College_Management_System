package com.homework.week3.college.management.system.hw3.services;

import com.homework.week3.college.management.system.hw3.dtos.AdmissionRecordDto;
import com.homework.week3.college.management.system.hw3.dtos.ProfessorDto;
import com.homework.week3.college.management.system.hw3.entities.AdmissionRecord;
import com.homework.week3.college.management.system.hw3.entities.Professor;
import com.homework.week3.college.management.system.hw3.repositories.ProfessorRepo;
import org.apache.catalina.LifecycleState;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService
{
    private final ProfessorRepo professorRepo;
    private final ModelMapper modelMapper;

    public ProfessorService(ProfessorRepo professorRepo, ModelMapper modelMapper)
    {
        this.professorRepo = professorRepo;
        this.modelMapper = modelMapper;
    }

    //create

    public ProfessorDto createNewProfessor(ProfessorDto inputData)
    {
        Professor convertToEntity=modelMapper.map(inputData, Professor.class);
        Professor savedEntity=professorRepo.save(convertToEntity);
        ProfessorDto convertToDtoBack=modelMapper.map(savedEntity, ProfessorDto.class);

        return convertToDtoBack;
    }

    //Get by idd
    public ProfessorDto getProfessorById(Long id)
    {
        Professor fetchFromDB=professorRepo.findById(id).orElse(null);

        ProfessorDto convertToDto=modelMapper.map(fetchFromDB, ProfessorDto.class);

        return convertToDto;

    }

    //getAll

    public List<ProfessorDto> getAllProfessor()
    {
        List<Professor> fetchAllFromDb=professorRepo.findAll();

        List<ProfessorDto> convertToDtoList=fetchAllFromDb.stream().map(record->modelMapper.map(record, ProfessorDto.class)).toList();

        return convertToDtoList;
    }

    //updateById

    public ProfessorDto updateById(Long id,ProfessorDto inputData)
    {
        Professor getFromDB=professorRepo.findById(id).orElse(null);

        modelMapper.map(inputData, getFromDB);

        ProfessorDto convertBackToDto=modelMapper.map(getFromDB, ProfessorDto.class);

        return convertBackToDto;

    }

    //deleteById

    public Boolean deleteById(Long id)
    {
        if(professorRepo.findById(id).isPresent()==true)
        {
            professorRepo.deleteById(id);
            return true;
        }

        return false;
    }

    public Boolean deleteAll()
    {
        if(professorRepo.findAll().isEmpty()==false)
        {
            professorRepo.deleteAll();
            return true;
        }
        return false;
    }

}
