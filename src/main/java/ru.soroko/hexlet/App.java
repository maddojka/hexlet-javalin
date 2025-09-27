package ru.soroko.hexlet;

import io.javalin.Javalin;

import java.util.List;
import java.util.Map;

public final class App {
    private static final List<Map<String, String>> COMPANIES = List.of(Map.of(
            "id", "3",
            "name", "Google",
            "telephone", "12345678"
    ));
    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Integer.class).get();
            Map<String, String> user = COMPANIES.get(id); // Ищем пользователя в базе по id
            if (user != null) {
                ctx.json(user);
            } else {
                ctx.status(404);
            }
        });
        return app;
    }
    public static void main(String[] args) {
        Javalin app = getApp();
        app.start("0.0.0.0", 8080);
    }
}
