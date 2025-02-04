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

    public SubjectDto()
    {

    }

    public SubjectDto(Long subject_id, String title, Professor professor, List<Student> studentList) {
        this.subject_id = subject_id;
        this.title = title;
        this.professor = professor;
        this.studentList = studentList;
    }

    public Long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Long subject_id) {
        this.subject_id = subject_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
