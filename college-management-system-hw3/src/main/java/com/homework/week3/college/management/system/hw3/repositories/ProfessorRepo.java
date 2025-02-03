package com.homework.week3.college.management.system.hw3.repositories;

import com.homework.week3.college.management.system.hw3.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepo extends JpaRepository<Professor,Long> {
}
