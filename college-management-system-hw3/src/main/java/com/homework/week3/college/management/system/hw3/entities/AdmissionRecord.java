package com.homework.week3.college.management.system.hw3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Admission Record")

public class AdmissionRecord
{
   @Id
  // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long admission_id;

    private int fees;

    @OneToOne(mappedBy = "admissionRecord",cascade = CascadeType.ALL)
    @JsonIgnore
    private Student student;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public AdmissionRecord()
    {

    }

    public AdmissionRecord(Long admission_id, int fees, Student student) {
        this.admission_id = admission_id;
        this.fees = fees;
        this.student = student;
    }


}
