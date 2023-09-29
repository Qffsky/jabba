package com.step4kap.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "paypolicy")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Policy implements CommonEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "policyid")
    private Integer id;

    @Column(name = "policytype")
    private String policyType;

    @Column(name = "policydescription")
    private String policyDescription;
}
