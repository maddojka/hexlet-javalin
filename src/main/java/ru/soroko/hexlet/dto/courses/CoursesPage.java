package ru.soroko.hexlet.dto.courses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.soroko.hexlet.model.Course;

import java.util.List;

@AllArgsConstructor
@Getter
public class CoursesPage {
    private List<Course> courses;
    private String header;
}