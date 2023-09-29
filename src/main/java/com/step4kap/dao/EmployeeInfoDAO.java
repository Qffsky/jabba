package com.step4kap.dao;

import com.step4kap.db.EmployeeInfo;
import com.step4kap.db.Project;
import org.yaml.snakeyaml.events.Event;

import java.util.Collection;
import java.util.List;

public class EmployeeInfoDAO extends CommonDAO<EmployeeInfo, Integer>{

    public EmployeeInfoDAO() {
        super(EmployeeInfo.class);
    }

    public List<EmployeeInfo> getAllEmployeeInfoByName(String fullname) {
        return null;
    }
}
