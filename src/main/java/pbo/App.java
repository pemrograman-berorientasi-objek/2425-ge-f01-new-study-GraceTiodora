package pbo;

import java.util.*;
import javax.persistence.*;
import pbo.Executor;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Student> students = new HashMap<>();
        Map<String, Course> courses = new HashMap<>();
        Map<String, List<Course>> enrollments = new HashMap<>();

        while (sc.hasNextLine()) {
            String[] parts = sc.nextLine().split("#");
            switch (parts[0]) {
                case "student-add": {
                    String id = parts[1], name = parts[2], program = parts[3];
                    Student s = new Student(id, name, program);
                    students.put(id, s);
                    break;
                }
                case "course-add": {
                    String id = parts[1], name = parts[2];
                    int semester = Integer.parseInt(parts[3]);
                    int credit = Integer.parseInt(parts[4]);
                    Course c = new Course(id, name, semester, credit);
                    courses.put(id, c);
                    break;
                }
                case "enroll": {
                    String sid = parts[1], cid = parts[2];
                    Course course = courses.get(cid);
                    enrollments.computeIfAbsent(sid, k -> new ArrayList<>()).add(course);
                    break;
                }
                case "student-show": {
                    String sid = parts[1];
                    Student s = students.get(sid);
                    System.out.println(s);
                    enrollments.getOrDefault(sid, new ArrayList<>())
                               .forEach(c -> System.out.println(c));
                    break;
                }
            }
        }

        sc.close();
    }
}
