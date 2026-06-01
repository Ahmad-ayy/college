package com.example.college.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "program")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "total_credits")
    private Integer totalCredits;

    /**
     * Type of program — e.g., BD (Bachelor's Degree), MP (Master's Program)
     */
    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "sem_id", nullable = false)
    private Semester semester;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
    private List<Course> courses;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getTotalCredits() { return totalCredits; }
    public void setTotalCredits(Integer totalCredits) { this.totalCredits = totalCredits; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Semester getSemester() { return semester; }
    public void setSemester(Semester semester) { this.semester = semester; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }

    public List<Enrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(List<Enrollment> enrollments) { this.enrollments = enrollments; }
}
