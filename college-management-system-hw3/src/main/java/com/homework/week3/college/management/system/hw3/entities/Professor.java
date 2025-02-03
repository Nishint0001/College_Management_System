package com.homework.week3.college.management.system.hw3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Professor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Professor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professor_id;

    private String title;

    @OneToMany(mappedBy = "professor")
    private List<Subject> subjectList;

    @ManyToMany(mappedBy = "professorList")
    private List<Student> studentList;

}
