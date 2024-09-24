package hexlet.code.model;

import lombok.Getter;

import java.time.format.DateTimeFormatter;
@Getter
public abstract class BaseUrl {
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
}
