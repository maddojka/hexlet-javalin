package ru.soroko.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import ru.soroko.hexlet.dto.courses.CoursesPage;
import ru.soroko.hexlet.model.Course;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        final List<Course> COURSES = List.of(new Course("Java", "junior"),
                new Course("C++", "middle"));

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/courses", ctx -> {
            var header = "Курсы по программированию";
            var page = new CoursesPage(COURSES, header);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.start(8080); // Стартуем веб-сервер
    }
}