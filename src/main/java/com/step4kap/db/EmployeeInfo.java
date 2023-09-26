package com.step4kap.db;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employeeinfo")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeInfo implements CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "employeeid")
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "homeaddress")
    private String homeAddress;

    @Column(name = "education")
    private String education;

    @Column(name = "workexperience")
    private String workExperience;
}
