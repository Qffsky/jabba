package com.step4kap.dao;

import com.step4kap.db.EmployeeInfo;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations="classpath:application.properties")
public class EmployeeInfoDAOTest {

    @Autowired
    private EmployeeInfoDAO employeeInfoDAO;
    @Autowired
    private SessionFactory sessionFactory;

    @Test
    void testSimple() {
        List<EmployeeInfo> employeeInfoListAll = (List<EmployeeInfo>) employeeInfoDAO.getAll();
        Assertions.assertEquals(15, employeeInfoListAll.size());

        List<EmployeeInfo> expertQuery = employeeInfoDAO.getAllEmployeeInfoByTitle("expert");
        Assertions.assertEquals(2, expertQuery.size());

        EmployeeInfo employeeInfo3 = employeeInfoDAO.getById(3);
        Assertions.assertEquals(3, employeeInfo3.getId());

        EmployeeInfo employeeInfoNotExist = employeeInfoDAO.getById(100);
        Assertions.assertNull(employeeInfoNotExist);
    }

    @BeforeEach
    void beforeEach() {
        List<EmployeeInfo> employeeInfoList = new ArrayList<>();
        employeeInfoList.add(new EmployeeInfo(1, "Образцов Пример Шаблонович1", "", "", "", "expert", 100));
        employeeInfoList.add(new EmployeeInfo(2, "Образцов Пример Шаблонович2", "", "", "", "expert", 100));
        employeeInfoList.add(new EmployeeInfo(3, "Образцов Пример Шаблонович3", "", "", "", "", 100));

        employeeInfoList.add(new EmployeeInfo(4, "Образцов Пример Шаблонович4", "", "", "", "", 100));
        employeeInfoList.add(new EmployeeInfo(5, "Образцов Пример Шаблонович5", "", "", "", "", 100));
        employeeInfoList.add(new EmployeeInfo(6, "Образцов Пример Шаблонович6", "", "", "", "", 100));
        employeeInfoDAO.saveCollection(employeeInfoList);
    }
}
