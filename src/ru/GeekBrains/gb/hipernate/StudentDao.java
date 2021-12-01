package ru.GeekBrains.gb.hipernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Random;

public class StudentDao {
    private static SessionFactory factory;
    private static final Random random = new Random();

    public static void main(String[] args) {
        init();
        deleteAll();
        createStudents();
        System.out.println(findById(3159));
  //      update(new Student("new", 5));
        System.out.println(findById(3159));
        close();
    }

    public static void createStudents() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            for (int i = 0; i < 1000; i++) {
                session.save(new Student("Student_" + i, random.nextInt(5) + 1));
            }
            session.getTransaction().commit();
        }
    }

    public static void delete(Student student) {
        factory.getCurrentSession().delete(student);
    }

//    public static void update(Student student) {
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//        factory.getCurrentSession().update(student);
//        session.getTransaction().commit();
//    }

    public static Student findById(long id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student student = factory.getCurrentSession().get(Student.class, id);
        session.getTransaction().commit();
        return student;
    }

    @SuppressWarnings("unchecked")
    public static List<Student> findAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Student> students = (List<Student>) session.createQuery("from Student").setCacheable(true).list();
        session.getTransaction().commit();
        return students;
    }

    public static void deleteAll() {
        List<Student> students = findAll();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        for (Student student:students) {
            delete(student);
        }
        session.getTransaction().commit();
    }

    public static void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void close() {
        factory.close();
    }
}
