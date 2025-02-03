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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subject
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subject_id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToMany(mappedBy = "subjectList")
    private List<Student> studentList;

}
