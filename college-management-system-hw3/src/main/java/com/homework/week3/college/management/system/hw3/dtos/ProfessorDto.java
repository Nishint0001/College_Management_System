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


    public ProfessorDto()
    {

    }

    public ProfessorDto(Long professor_id, String title, List<Subject> subjectList, List<Student> studentList) {
        this.professor_id = professor_id;
        this.title = title;
        this.subjectList = subjectList;
        this.studentList = studentList;
    }

    public Long getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(Long professor_id) {
        this.professor_id = professor_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
