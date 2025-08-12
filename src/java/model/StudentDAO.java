package model;

import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.Criteria;
//import org.hibernate.criterion.Restrictions;
//import org.hibernate.Hibernate;
//import org.hibernate.ObjectNotFoundException;

import java.util.List;

/**
 * Data Access Object for Student entity.
 */
public class StudentDAO {


    /*
    public Long save(Student s) {
        Session session = HibernateUtil.openSession();
        try {
            Transaction tx = session.beginTransaction();
            Long id = (Long) session.save(s);
            tx.commit();
            return id;
        } finally {
            session.close();
        }
    }
    */


    /*
    public void update(Student s) {
        Session session = HibernateUtil.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.update(s);
            tx.commit();
        } finally {
            session.close();
        }
    }
    */


    /*
    public void delete(Long id) {
        Session session = HibernateUtil.openSession();
        try {
            Transaction tx = session.beginTransaction();
            Student s = (Student) session.get(Student.class, id);
            if (s != null) session.delete(s);
            tx.commit();
        } finally {
            session.close();
        }
    }
    */


    /*
    public Student get(Long id) {
        Session session = HibernateUtil.openSession();
        try {
            return (Student) session.get(Student.class, id);
        } finally {
            session.close();
        }
    }
    */


    /*
    public Student load(Long id) {
        Session session = HibernateUtil.openSession();
        try {
            try {
                Student proxy = (Student) session.load(Student.class, id);
                Hibernate.initialize(proxy);
                return proxy;
            } catch (ObjectNotFoundException e) {
                return null;
            }
        } finally {
            session.close();
        }
    }
    */


    /*
    @SuppressWarnings("unchecked")
    public List<Student> findByName(String name) {
        Session session = HibernateUtil.openSession();
        try {
            Criteria c = session.createCriteria(Student.class)
                    .add(Restrictions.eq("name", name));
            return c.list();
        } finally {
            session.close();
        }
    }
    */

    @SuppressWarnings("unchecked")
    public List<Student> listAll() {
        Session session = HibernateUtil.openSession();
        try {
            return session.createCriteria(Student.class).list();
        } finally {
            session.close();
        }
    }
}
