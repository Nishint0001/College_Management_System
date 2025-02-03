package com.homework.week3.college.management.system.hw3.dtos;

import com.homework.week3.college.management.system.hw3.entities.Student;
import com.homework.week3.college.management.system.hw3.entities.Subject;
import jakarta.persistence.*;

import java.util.List;

public class ProfessorDto
{
    private Long professor_id;

    private String title;

    private List<Subject> subjectList;

    private List<Student> studentList;

}
