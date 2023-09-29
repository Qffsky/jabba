package com.step4kap.db;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employeeinfo")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfo implements CommonEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "employeeid")
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "homeaddress")
    private String homeAddress;

    @Column(name = "education")
    private String education;

    @Column(name = "workexperience")
    private String workExperience;

    @Column(name = "jobtitle")
    private String jobTitle;

    @Column(name = "salary")
    private Integer salary;
}
