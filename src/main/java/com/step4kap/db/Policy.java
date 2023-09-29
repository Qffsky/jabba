package com.step4kap.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;
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
