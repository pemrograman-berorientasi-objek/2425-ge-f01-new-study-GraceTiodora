package pbo;

public class Course {
    private String courseId;
    private String courseName;
    private int semester;
    private int credit;

    public Course() {}

    public Course(String courseId, String courseName, int semester, int credit) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.semester = semester;
        this.credit = credit;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getSemester() {
        return semester;
    }

    public int getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        return courseId + "|" + courseName + "|" + semester + "|" + credit;
    }
}