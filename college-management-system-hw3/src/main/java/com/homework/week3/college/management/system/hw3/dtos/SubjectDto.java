package com.homework.week3.college.management.system.hw3.dtos;

import com.homework.week3.college.management.system.hw3.entities.Professor;
import com.homework.week3.college.management.system.hw3.entities.Student;
import jakarta.persistence.*;

import java.util.List;

public class SubjectDto
{

    private Long subject_id;

    private String title;

    private Professor professor;

    private List<Student> studentList;

}
