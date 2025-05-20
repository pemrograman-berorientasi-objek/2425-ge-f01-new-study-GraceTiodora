package pbo;

import javax.persistence.*;
import java.util.*;

public class Executor {
    private EntityManager entityManager;

    public Executor(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cleanUpTables() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Enrollment").executeUpdate();
        entityManager.createQuery("DELETE FROM Course").executeUpdate();
        entityManager.createQuery("DELETE FROM Student").executeUpdate();
        entityManager.getTransaction().commit();
    }

    public void addStudent(String[] data) {
        entityManager.getTransaction().begin();
        String id = data[1];
        String name = data[2];
        String program = data[3];

        if (entityManager.find(Student.class, id) == null) {
            Student student = new Student(id, name, program);
            entityManager.persist(student);
        }
        entityManager.getTransaction().commit();
    }

    public void addCourse(String[] data) {
        entityManager.getTransaction().begin();
        String id = data[1];
        String name = data[2];
        int semester = Integer.parseInt(data[3]);
        int credit = Integer.parseInt(data[4]);

        if (entityManager.find(Course.class, id) == null) {
            Course course = new Course(id, name, semester, credit);
            entityManager.persist(course);
        }
        entityManager.getTransaction().commit();
    }

    public void enrollStudent(String[] data) {
        entityManager.getTransaction().begin();
        String studentId = data[1];
        String courseId = data[2];

        Student student = entityManager.find(Student.class, studentId);
        Course course = entityManager.find(Course.class, courseId);

        if (student != null && course != null) {
            Enrollment enrollment = new Enrollment(student, course);
            entityManager.persist(enrollment);
        }
        entityManager.getTransaction().commit();
    }

    public void showStudent(String[] data) {
        String studentId = data[1];
        Student student = entityManager.find(Student.class, studentId);

        if (student != null) {
            System.out.println(student);
            TypedQuery<Enrollment> query = entityManager.createQuery(
                "SELECT e FROM Enrollment e WHERE e.student.studentId = :sid", Enrollment.class);
            query.setParameter("sid", studentId);
            List<Enrollment> enrollments = query.getResultList();
            for (Enrollment e : enrollments) {
                System.out.println(e.getCourse());
            }
        }
    }
}
