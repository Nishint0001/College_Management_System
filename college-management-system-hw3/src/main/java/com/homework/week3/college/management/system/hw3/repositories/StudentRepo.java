package com.homework.week3.college.management.system.hw3.repositories;

import com.homework.week3.college.management.system.hw3.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
