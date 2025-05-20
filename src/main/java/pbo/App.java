package pbo;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Student> students = new HashMap<>();
        Map<String, Course> courses = new HashMap<>();

        List<String> output = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.equals("---")) break;
            if (line.isEmpty()) continue;
            String[] parts = line.split("#");

            switch (parts[0]) {
                case "student-add": {
                    String id = parts[1], name = parts[2], program = parts[3];
                    if (!students.containsKey(id)) {
                        students.put(id, new Student(id, name, program));
                    }
                    break;
                }
                case "course-add": {
                    String id = parts[1], name = parts[2];
                    int semester = Integer.parseInt(parts[3]);
                    int credit = Integer.parseInt(parts[4]);
                    if (!courses.containsKey(id)) {
                        courses.put(id, new Course(id, name, semester, credit));
                    }
                    break;
                }
                case "student-show-all": {
                    List<Student> sortedStudents = new ArrayList<>(students.values());
                    sortedStudents.sort(Comparator.comparing(Student::getStudentId));
                    for (Student s : sortedStudents) {
                        output.add(s.toString());
                    }
                    break;
                }
                case "course-show-all": {
                    List<Course> sortedCourses = new ArrayList<>(courses.values());
                    sortedCourses.sort(Comparator.comparing(Course::getSemester)
                        .thenComparing(Course::getCourseId));
                    for (Course c : sortedCourses) {
                        output.add(c.toString());
                    }
                    break;
                }
            }
        }
        sc.close();

        // Print all output at the end
        for (String s : output) {
            System.out.println(s);
        }
    }
}