package com.example.spring_sprint2.services;


import com.example.spring_sprint2.model.Course;
import com.example.spring_sprint2.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    public final CourseRepository courseRepository;

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

}
