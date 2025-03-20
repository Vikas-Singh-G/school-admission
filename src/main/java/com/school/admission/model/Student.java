package com.school.admission.model;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity // Marks this class as a JPA entity (linked to a database table)
@Table(name = "students") // Defines the table name in the database
public class Student {
    
    private static final Logger logger = LoggerFactory.getLogger(Student.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;

    @Column(nullable = false) // Cannot be null
    private String name;

    @Column(unique = true, nullable = false) // Unique constraint for email
    private String email;

    @Column(nullable = false)
    private String course;

    // Constructor (for debugging & logging)
    public Student() {
        logger.info("Student entity created");
    }

    public Student(String name, String email, String course) {
        this.name = name;
        this.email = email;
        this.course = course;
        logger.info("Student created: {}", this);
    }

    //  Getters & Setters (Used for accessing private fields)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    //ToString (For debugging & logging)
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
