package com.homework.week3.college.management.system.hw3.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class modelMapperConfig
{
    @Bean
    public ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }

}
