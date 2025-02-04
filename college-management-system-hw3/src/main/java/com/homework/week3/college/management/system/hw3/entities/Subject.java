package com.homework.week3.college.management.system.hw3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;
import java.util.List;

@Entity
@Table(name = "Subject")

public class Subject
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subject_id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToMany(mappedBy = "subjectList",cascade = CascadeType.ALL)
    private List<Student> studentList;

    public Subject()
    {

    }

    public Subject(Long subject_id, String title, Professor professor, List<Student> studentList) {
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
