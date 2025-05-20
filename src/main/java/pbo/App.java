package pbo;

import java.util.*;
import javax.persistence.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Student> students = new LinkedHashMap<>(); // urutan input mahasiswa
        Map<String, Course> courses = new LinkedHashMap<>();   // urutan input mata kuliah
        Map<String, LinkedHashSet<Course>> enrollments = new LinkedHashMap<>(); // urutan input enroll per student + unik

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
                    if(course != null){
                        enrollments.computeIfAbsent(sid, k -> new LinkedHashSet<>()).add(course);
                    }
                    break;
                }
                case "student-show": {
                    String sid = parts[1];
                    Student s = students.get(sid);
                    if (s != null) {
                        System.out.println(s);

                        // Dapatkan daftar course yang di-enroll, urutkan berdasarkan courseId agar konsisten
                        LinkedHashSet<Course> enrolledCourses = enrollments.getOrDefault(sid, new LinkedHashSet<>());

                        List<Course> sortedCourses = new ArrayList<>(enrolledCourses);
                        sortedCourses.sort(Comparator.comparing(Course::getCourseId));

                        for (Course c : sortedCourses) {
                            System.out.println(c);
                        }
                    }
                    break;
                }
            }
        }
        sc.close();
    }
}
