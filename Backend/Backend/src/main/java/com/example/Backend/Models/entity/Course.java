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
    private User professor;

    @ElementCollection
    private List<String> materials;

    @Column(nullable = true)
    private String syllabus;

    @Column(nullable = true)
    private Integer duration;

    @Column(nullable = true)
    private String level;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    public Course() {
        this.createdDate = LocalDateTime.now();
    }

}