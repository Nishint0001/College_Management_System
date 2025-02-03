package com.homework.week3.college.management.system.hw3.repositories;

import com.homework.week3.college.management.system.hw3.entities.AdmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRecordRepo extends JpaRepository<AdmissionRecord,Long>
{

}
