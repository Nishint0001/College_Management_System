package com.homework.week3.college.management.system.hw3.services;

import com.homework.week3.college.management.system.hw3.dtos.AdmissionRecordDto;
import com.homework.week3.college.management.system.hw3.entities.AdmissionRecord;
import com.homework.week3.college.management.system.hw3.repositories.AdmissionRecordRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdmissionRecordService
{
    private final AdmissionRecordRepo admissionRecordRepo;
    private final ModelMapper modelMapper;

    public AdmissionRecordService(AdmissionRecordRepo admissionRecordRepo, ModelMapper modelMapper)
    {
        this.admissionRecordRepo = admissionRecordRepo;
        this.modelMapper = modelMapper;
    }

    //WILL FOLLOW CRUD create get,get all update and delete for now ..

    //create

    public AdmissionRecordDto createNewAdmission(AdmissionRecordDto inputData)
    {
        AdmissionRecord convertToEntity=modelMapper.map(inputData, AdmissionRecord.class);
        AdmissionRecord savedEntity=admissionRecordRepo.save(convertToEntity);
        AdmissionRecordDto convertToDtoBack=modelMapper.map(savedEntity, AdmissionRecordDto.class);

        return convertToDtoBack;
    }

    //getById
    public AdmissionRecordDto getAdmissionById(Long id)
    {
        AdmissionRecord getById=admissionRecordRepo.findById(id).orElse(null);
        AdmissionRecordDto convertToDto=modelMapper.map(getById, AdmissionRecordDto.class);

        return  convertToDto;

    }

    //getAllById
    public List<AdmissionRecordDto> getAllAdmission()
    {
        List<AdmissionRecord> getAll=admissionRecordRepo.findAll();
        List<AdmissionRecordDto> convertToListDto=
                getAll.stream()
                        .map(record->modelMapper.map(record,AdmissionRecordDto.class))
                        .collect(Collectors.toList());

        return convertToListDto;
    }

    //updateById

    public AdmissionRecordDto updateAdmissionById(Long id,AdmissionRecordDto admissionRecordDto)
    {
        AdmissionRecord getFromDB=admissionRecordRepo.findById(id).orElseThrow(()->new RuntimeException("Employee not found with id"+id));

        modelMapper.map(admissionRecordDto,getFromDB);//changed

        AdmissionRecordDto changedToDto=modelMapper.map(getFromDB,AdmissionRecordDto.class);

        return changedToDto;

    }

    //delete by id

    public String deleteById(Long id)
    {
        if(admissionRecordRepo.findById(id).isPresent()==true)
        {
            admissionRecordRepo.deleteById(id);
            return "DELETED SUCCESSSFULLLLLLY";
        }
        return "DATABASE not has THIS record";
    }

    //deleteAll

    public String deleteAll()
    {
        if(admissionRecordRepo.findAll().isEmpty()==false)
        {
            admissionRecordRepo.deleteAll();
            return "DELETED all SUCCESSSFULLLLLLY";
        }
        return "EMPTY DATABASE";
    }

}
