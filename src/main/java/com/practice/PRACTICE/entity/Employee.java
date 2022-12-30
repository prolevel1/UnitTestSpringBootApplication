package com.practice.PRACTICE.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "Employee")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long empId;

    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
