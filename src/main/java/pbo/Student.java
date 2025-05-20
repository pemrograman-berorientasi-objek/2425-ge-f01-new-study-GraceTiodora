package pbo;

public class Student {
    private String studentId;
    private String studentName;
    private String studyProgram;

    public Student() {}

    public Student(String studentId, String studentName, String studyProgram) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studyProgram = studyProgram;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    @Override
    public String toString() {
        return studentId + "|" + studentName + "|" + studyProgram;
    }
}