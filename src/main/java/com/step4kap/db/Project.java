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
@Table(name = "projects")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Project implements CommonEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "projectid")
    private Integer id;

    @Column(name = "projectname")
    private String projectName;

    @Column(name = "projectstart")
    private String projectStart;

    @Column(name = "projectend")
    private String projectEnd;
}
