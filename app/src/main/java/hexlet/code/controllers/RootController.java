package hexlet.code.controllers;

import hexlet.code.dto.BasePage;
import io.javalin.http.Context;

public class RootController {

    public static void index(Context ctx) {
        var page = new BasePage();
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flashType"));
        ctx.render("index.jte");
    }
}
