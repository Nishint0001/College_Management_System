package com.homework.week3.college.management.system.hw3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Student")
public class Student
{
    public Student()
    {

    }
    public Student(Long student_id, String name, AdmissionRecord admissionRecord, List<Professor> professorList, List<Subject> subjectList) {
        this.student_id = student_id;
        this.name = name;
        this.admissionRecord = admissionRecord;
        this.professorList = professorList;
        this.subjectList = subjectList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long student_id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admission_id")
    @JsonIgnore
    private AdmissionRecord admissionRecord;

    @ManyToMany
    @JoinTable
            (
                    name = "student_professor",
                    joinColumns = @JoinColumn(name = "student_id"),
                    inverseJoinColumns = @JoinColumn(name = "professor_id")

            )
    private List<Professor> professorList;


    @ManyToMany
    @JoinTable
            (
                    name = "student_subject",
                    joinColumns = @JoinColumn(name = "student_id"),
                    inverseJoinColumns = @JoinColumn(name = "subject_id")

            )
    private List<Subject> subjectList;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdmissionRecord getAdmissionRecord() {
        return admissionRecord;
    }

    public void setAdmissionRecord(AdmissionRecord admissionRecord) {
        this.admissionRecord = admissionRecord;
    }

    public List<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
