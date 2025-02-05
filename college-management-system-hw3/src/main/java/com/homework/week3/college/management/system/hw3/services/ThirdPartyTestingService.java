package com.homework.week3.college.management.system.hw3.services;

import com.homework.week3.college.management.system.hw3.dtos.ThirdPartyTestingEntityDto;
import com.homework.week3.college.management.system.hw3.entities.ThirdPartyTestingEntity;
import com.homework.week3.college.management.system.hw3.repositories.ThirdPartyTestingRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThirdPartyTestingService
{
    private final ThirdPartyTestingRepo thirdPartyTestingRepo;
    private final ModelMapper modelMapper;


    public ThirdPartyTestingService(ThirdPartyTestingRepo thirdPartyTestingRepo, ModelMapper modelMapper)
    {
        this.thirdPartyTestingRepo = thirdPartyTestingRepo;
        this.modelMapper = modelMapper;
    }

    //create

    public ThirdPartyTestingEntityDto createpost(ThirdPartyTestingEntityDto input)
    {
        ThirdPartyTestingEntity convertToEntity=modelMapper.map(input, ThirdPartyTestingEntity.class);

        ThirdPartyTestingEntity savedEntity=thirdPartyTestingRepo.save(convertToEntity);

        ThirdPartyTestingEntityDto convertToDto=modelMapper.map(savedEntity, ThirdPartyTestingEntityDto.class);

        return convertToDto;

    }

    //getAll

    public List<ThirdPartyTestingEntityDto> getAll()
    {
        List<ThirdPartyTestingEntity> getFromDb=thirdPartyTestingRepo.findAll();

        List<ThirdPartyTestingEntityDto> convertBackToDto=getFromDb.stream().map(record->modelMapper.map(record, ThirdPartyTestingEntityDto.class)).toList();

        return convertBackToDto;
    }

}
