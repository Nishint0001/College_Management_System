package com.homework.week3.college.management.system.hw3.dtos;

import com.homework.week3.college.management.system.hw3.entities.AdmissionRecord;
import com.homework.week3.college.management.system.hw3.entities.Professor;
import com.homework.week3.college.management.system.hw3.entities.Subject;
import jakarta.persistence.*;

import java.util.List;

public class StudentDto
{
    private Long student_id;

    private String name;

    private AdmissionRecord admissionRecord;

    private List<Professor> professorList;

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

    public StudentDto()
    {

    }

    public StudentDto(Long student_id, String name, AdmissionRecord admissionRecord, List<Professor> professorList, List<Subject> subjectList) {
        this.student_id = student_id;
        this.name = name;
        this.admissionRecord = admissionRecord;
        this.professorList = professorList;
        this.subjectList = subjectList;
    }
}


