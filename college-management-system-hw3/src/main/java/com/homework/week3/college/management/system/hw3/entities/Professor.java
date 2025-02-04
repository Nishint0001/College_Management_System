package com.homework.week3.college.management.system.hw3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Professor")

public class Professor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professor_id;

    private String title;

    @OneToMany(mappedBy = "professor",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Subject> subjectList;

    @ManyToMany(mappedBy = "professorList",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Student> studentList;

    public Professor()
    {

    }

    public Professor(Long professor_id, String title, List<Subject> subjectList, List<Student> studentList) {
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

    public void setStudentList(List<Student> studentList)
    {
        this.studentList = studentList;
    }

}
