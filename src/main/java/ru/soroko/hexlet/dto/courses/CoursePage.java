package ru.soroko.hexlet.dto.courses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.soroko.hexlet.model.Course;

@AllArgsConstructor
@Getter
public class CoursePage {
    private Course course;
}