package com.example.Backend.Models.DTOs;

import com.example.Backend.Models.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseDTO {
    private int id;
    private String title;
    private String description;
    private User professor;
    private List<String> materials;
    private String syllabus;
    private Integer duration;
    private String level;
    private LocalDateTime createdDate;
}
