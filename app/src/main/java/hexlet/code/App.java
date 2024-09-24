package hexlet.code;

import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static Javalin getApp() {
        log.info("Создаём Javalin instance");

        return Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        }).get("/", ctx -> {
            ctx.result("Hello World");
        });
    }

    public static void main(String[] args) {
        log.info("Запускаем приложение");

        Javalin app = getApp();
        app.start(7000);

        log.info("Приложение успешно запущено на порту 7000");
    }
}
