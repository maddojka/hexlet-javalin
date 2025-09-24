package ru.soroko.hexlet;

import io.javalin.Javalin;

public final class App {
    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });



        return app;
    }
    public static void main(String[] args) {
        Javalin app = getApp();
        app.start("0.0.0.0", 8080);
    }
}
