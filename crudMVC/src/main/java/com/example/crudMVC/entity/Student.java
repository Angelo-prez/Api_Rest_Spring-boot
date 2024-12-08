package com.example.crudMVC.entity;

import com.fasterxml.jackson.databind.util.ClassUtil;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String firstName;

    private String lastName;

    @Column(name="email_address", unique=true,nullable = false)
    private String email;
}
