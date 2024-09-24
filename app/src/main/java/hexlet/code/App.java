package hexlet.code;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import hexlet.code.repository.BaseRepository;
import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.stream.Collectors;

@Slf4j
public class App {

    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }

    private static String getDBURL() {
        return  System.getenv()
                .getOrDefault("JDBC_DATABASE_URL",
                        "jdbc:h2:mem:project;DB_CLOSE_DELAY=-1;");
    }

    public static Javalin getApp() throws SQLException {
        log.info("Создаём Javalin instance");

        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(getDBURL());
        var dataSource = new HikariDataSource(hikariConfig);
        var url = App.class.getClassLoader().getResourceAsStream("schema.sql");
        var sql = new BufferedReader(new InputStreamReader(url))
                .lines().collect(Collectors.joining("\n"));
        log.info(sql);
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        }
        BaseRepository.dataSource = dataSource;

        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.bundledPlugins.enableDevLogging();
        });
        return Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        }).get("/", ctx -> {
            ctx.result("Hello World");
        });
    }

    public static void main(String[] args) throws SQLException {
        log.info("Запускаем приложение");

        var app = getApp();
        app.start(getPort());

        log.info("Приложение успешно запущено на порту 7000");
    }
}
