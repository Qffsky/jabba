package com.step4kap.dao;

import com.step4kap.db.EmployeeInfo;
import com.step4kap.db.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.yaml.snakeyaml.events.Event;

import org.hibernate.query.Query;
import java.util.Collection;
import java.util.List;

public class EmployeeInfoDAO extends CommonDAO<EmployeeInfo, Integer>{

    public EmployeeInfoDAO() {
        super(EmployeeInfo.class);
    }

    public List<EmployeeInfo> getAllEmployeeInfoByTitle(String title) {
        try (Session session = sessionFactory.openSession()) {
            Query<EmployeeInfo> query = session.createQuery("FROM employeeinfo WHERE jobtitle LIKE :name", EmployeeInfo.class)
                    .setParameter("name", "%" + title + "%");

            return query.getResultList().isEmpty() ? null : query.getResultList();
        }
    }
}
