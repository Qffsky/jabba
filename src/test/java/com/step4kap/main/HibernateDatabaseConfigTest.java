package com.step4kap.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.TestPropertySource;

import static org.testng.AssertJUnit.assertNotNull;

@SpringBootTest
@TestPropertySource(locations="classpath:application.properties")
class HibernateDatabaseConfigTest {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Test
    public void test() {
        SessionFactory sessionFactoryObject = sessionFactory.getObject();
        assertNotNull(sessionFactoryObject);
        Session session = sessionFactoryObject.openSession();
        assertNotNull(session);
    }
}