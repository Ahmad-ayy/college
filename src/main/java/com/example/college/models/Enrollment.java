package com.example.college.models;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "st_id")
    private Student student;

    @ManyToOne
    @MapsId("programId")
    @JoinColumn(name = "prog_id")
    private Program program;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    public Enrollment() {}

    public Enrollment(Student student, Program program, Course course) {
        this.student = student;
        this.program = program;
        this.course = course;
        this.id = new EnrollmentId(student.getId(), program.getId(), course.getId());
    }

    // Getters & Setters
    public EnrollmentId getId() { return id; }
    public void setId(EnrollmentId id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Program getProgram() { return program; }
    public void setProgram(Program program) { this.program = program; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
