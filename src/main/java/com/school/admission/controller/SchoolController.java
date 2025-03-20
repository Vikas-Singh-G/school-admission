package com.school.admission.controller; // Ensure package name is correct

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/school") // Base path
public class SchoolController {

    @GetMapping("/welcome") // This maps to /api/school/welcome
    public String welcome() {
        return "Welcome to School Admission System!";
    }
}

