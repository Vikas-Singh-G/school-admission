package com.school.admission.service;

import com.school.admission.entity.Student;
import com.school.admission.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;

    // Constructor Injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Add a New Student
    public Student addStudent(Student student) {
        logger.info("Adding new student: {}", student);
        return studentRepository.save(student);
    }

    //  Get All Students
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        logger.info("Fetched {} students from the database", students.size());
        return students;
    }

    // Get Student by ID
    public Student getStudentById(Long id) {
        logger.debug("Searching for student with ID: {}", id);
        return studentRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Student with ID {} not found", id);
                    return new RuntimeException("Student not found");
                });
    }

    // Update Student
    public Student updateStudent(Long id, Student updatedStudent) {
        logger.debug("Updating student with ID: {}", id);
        return studentRepository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setCourse(updatedStudent.getCourse());
            logger.info("Student updated: {}", student);
            return studentRepository.save(student);
        }).orElseThrow(() -> {
            logger.warn("Student with ID {} not found for update", id);
            return new RuntimeException("Student not found");
        });
    }

    // Delete Student
    public void deleteStudent(Long id) {
        logger.debug("Deleting student with ID: {}", id);
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            logger.info("Student with ID {} deleted successfully", id);
        } else {
            logger.warn("Student with ID {} not found for deletion", id);
            throw new RuntimeException("Student not found");
        }
    }
}
