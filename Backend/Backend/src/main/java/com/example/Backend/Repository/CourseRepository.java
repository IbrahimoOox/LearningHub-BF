package com.example.Backend.Repository;

import com.example.Backend.Models.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // You can define custom query methods here if needed
}