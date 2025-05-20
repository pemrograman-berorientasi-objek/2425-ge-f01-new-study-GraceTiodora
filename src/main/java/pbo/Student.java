package pbo;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id", nullable = false, length = 255)
    private String studentId;

    @Column(name = "student_name", nullable = false, length = 255)
    private String studentName;

    @Column(name = "studyProgram", nullable = false, length = 25)
    private String studyProgram;

  

    public Student() {
        // empty constructor
    }

    public Student (String studentId, String studentName, String studyProgram) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studyProgram = studyProgram; 
    }

   
    public String getstudentId() {
        return studentId ;
    }

    public void setstudentId (String studentId) {
        this.studentId = studentId;
    }

    public String studentName() {
        return studentName;
    }

    public void setstudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getstudyProgram() {
        return studyProgram;
    }

    public void setstudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }

    @Override
    public String toString() {
        return studentId + "|" + studentName + "|" + studyProgram;
    }

    

}
