package com.school.admission.repository;

import com.school.admission.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Logger logger = LoggerFactory.getLogger(StudentRepository.class);

    // Custom method to find student by email
    Optional<Student> findByEmail(String email);

    // Logging for debugging
    default void logStudentDetails(Student student) {
        if (student != null) {
            logger.info("Student Found: {}", student);
        } else {
            logger.warn("No Student Found!");
        }
    }
}
