package com.step4kap.dao;

import com.step4kap.db.CommonEntity;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Collection;

public class CommonDAO<T extends CommonEntity<ID>, ID> implements DAO<T, ID> {

    protected SessionFactory sessionFactory;

    protected Class<T> persistentClass;

    public CommonDAO(Class<T> entityClass){
        this.persistentClass = entityClass;
    }

    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory.getObject();
    }

    @Override
    public T getById(ID id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(persistentClass, id);
        }
    }

    @Override
    public Collection<T> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<T> criteriaQuery = session.getCriteriaBuilder().createQuery(persistentClass);
            criteriaQuery.from(persistentClass);
            return session.createQuery(criteriaQuery).getResultList();
        }
    }

    @Override
    public void save(T t) {
        try (Session session = sessionFactory.openSession()) {
            if (t.getId() != null) {
                t.setId(null);
            }
            session.beginTransaction();
            session.saveOrUpdate(t);
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveCollection(Collection<T> ts) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            for (T entity : ts) {
                this.save(entity);
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(T t) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(t);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(ID id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            T entity = getById(id);
            session.delete(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(T t) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
        }
    }
}
