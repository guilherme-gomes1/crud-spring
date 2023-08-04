package com.guilherme.crudspring.dtos.mappers;

import org.springframework.stereotype.Component;

import com.guilherme.crudspring.dtos.CourseDTO;
import com.guilherme.crudspring.enums.Category;
import com.guilherme.crudspring.model.Course;

@Component
public class CourseMapper {

    public CourseDTO toDto(Course course) {
        if(course == null) {
            return null;
        }

        return new CourseDTO(course.getId(), course.getName(), "Front-end");
    }

    public Course toEntity(CourseDTO courseDTO) {
        if(courseDTO == null) {
            return null;
        }

        Course course = new Course();
        if(courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        course.setCategory(Category.FRONT_END);
        return course;
    }
    
}
