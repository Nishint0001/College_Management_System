package com.homework.week3.college.management.system.hw3.dtos;

import com.homework.week3.college.management.system.hw3.entities.Student;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AdmissionRecordDto
{
        public AdmissionRecordDto()
        {

        }

        public AdmissionRecordDto(Long admission_id, int fees, StudentDto student) {
                this.admission_id = admission_id;
                this.fees = fees;
                this.student = student;
        }

        private Long admission_id;

        private int fees;

        private StudentDto student;

        public Long getAdmission_id() {
                return admission_id;
        }

        public void setAdmission_id(Long admission_id) {
                this.admission_id = admission_id;
        }

        public int getFees() {
                return fees;
        }

        public void setFees(int fees) {
                this.fees = fees;
        }

        public StudentDto getStudent() {
                return student;
        }

        public void setStudent(StudentDto student)
        {
                this.student = student;
        }

}
