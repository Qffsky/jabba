package com.step4kap.dao;

import com.step4kap.db.Policy;

public class PolicyDAO extends CommonDAO<Policy, Integer>{
    public PolicyDAO() {
        super(Policy.class);
    }
}
