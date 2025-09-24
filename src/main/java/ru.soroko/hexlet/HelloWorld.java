package ru.soroko.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/hello", ctx -> {
            var name = ctx.queryParam("name");
            if (name != null) {
                ctx.result("Hello, " + name + "!");
            } else {
                ctx.result("Hello, World!");
            }
                });
        app.start(8080); // Стартуем веб-сервер
    }
}