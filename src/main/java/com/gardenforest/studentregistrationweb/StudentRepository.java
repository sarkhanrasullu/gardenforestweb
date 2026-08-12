package com.gardenforest.studentregistrationweb;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

public class StudentRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

    public List<StudentEntity> getList() {
        EntityManager em = emf.createEntityManager();
        List<StudentEntity> list = em
                .createQuery("select s from Student s", StudentEntity.class)
                .getResultList();//JPQL Java Persistence Query Language

        em.close();
        return list;
    }

    public void insert(StudentEntity student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(student);

        em.getTransaction().commit();

        em.close();
    }

    public void update(StudentEntity student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(student);

        em.getTransaction().commit();

        em.close();
    }

    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        StudentEntity studentEntity = em.find(StudentEntity.class, id);

        em.remove(studentEntity);

        em.getTransaction().commit();

        em.close();
    }

    public StudentEntity getById(Integer id) {
        EntityManager em = emf.createEntityManager();

        StudentEntity entity = em.find(StudentEntity.class, id);

        em.close();
        return entity;
    }

}
