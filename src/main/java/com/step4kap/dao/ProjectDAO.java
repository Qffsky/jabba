package com.step4kap.dao;

import com.step4kap.db.Project;

public class ProjectDAO extends CommonDAO<Project, Integer> {
    public ProjectDAO() {
        super(Project.class);
    }
}
