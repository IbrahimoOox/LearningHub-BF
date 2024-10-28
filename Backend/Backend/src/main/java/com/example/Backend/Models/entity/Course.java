package com.example.Backend.Models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private User professor; // Association with the User entity

    @ElementCollection
    private List<String> materials; // List of course materials (e.g., links, files)

    @Column(nullable = true)
    private String syllabus; // URL or path to the course syllabus

    @Column(nullable = true)
    private Integer duration; // Duration in hours

    @Column(nullable = true)
    private String level; // Course level (e.g., Beginner, Intermediate, Advanced)

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate; // Creation date of the course

    public Course() {
        this.createdDate = LocalDateTime.now(); // Set creation date to now
    }

}