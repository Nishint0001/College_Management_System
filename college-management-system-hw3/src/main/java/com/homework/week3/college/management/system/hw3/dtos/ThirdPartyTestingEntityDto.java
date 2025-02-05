package com.homework.week3.college.management.system.hw3.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ThirdPartyTestingEntityDto
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double salary;

    public ThirdPartyTestingEntityDto()
    {

    }
    public ThirdPartyTestingEntityDto(Long id, String name, Double salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getSalary()
    {
        return salary;
    }

    public void setSalary(Double salary)
    {
        this.salary = salary;
    }
}

