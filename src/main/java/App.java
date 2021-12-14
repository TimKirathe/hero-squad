import static spark.Spark.*;

import java.util.*;

import models.Team;
import spark.ModelAndView;
import spark.TemplateEngine;
import spark.template.handlebars.HandlebarsTemplateEngine;
import models.Hero;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/posts/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String superpower = request.queryParams("superpower");
            String weakness = request.queryParams("weakness");
            Hero hero = new Hero(name, age, superpower, weakness);
            model.put("heros", Hero.getAll());
            return new ModelAndView(model, "hero-view.hbs");
        }, new HandlebarsTemplateEngine());

        get("/post", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/posts/team", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-view.hbs");
        }, new HandlebarsTemplateEngine());

        post("/posts/team", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("teamName");
            String cause = request.queryParams("cause");
            Integer heroId1 = Integer.parseInt(request.queryParams("hero1"));
            Integer heroId2 = Integer.parseInt(request.queryParams("hero2"));
            Integer heroId3 = Integer.parseInt(request.queryParams("hero3"));
            Integer heroId4 = Integer.parseInt(request.queryParams("hero4"));
            Team team = new Team(name, cause, Hero.getById(heroId1), Hero.getById(heroId2), Hero.getById(heroId3), Hero.getById(heroId4));
            ArrayList<Integer> chosenIds = Team.getChosenHerosIds();
            for(int i = 0; i< chosenIds.size(); i++) {
                if(Integer.parseInt(request.queryParams("hero1")) == chosenIds.get(i) || Integer.parseInt(request.queryParams("hero2")) == chosenIds.get(i) || Integer.parseInt(request.queryParams("hero3")) == chosenIds.get(i) || Integer.parseInt(request.queryParams("hero4")) == chosenIds.get(i)) {
                    get("/posts/error", (request1, response1) -> {
                        Map<String, Object> model2 = new HashMap<>();
                        return new ModelAndView(model2, "error.hbs");
                    }, new HandlebarsTemplateEngine());
                }
            }
            model.put("teams", Team.getAll());
            model.put("chosenHeros", team.getChosenHeros());
            return new ModelAndView(model, "squad-view.hbs");
        }, new HandlebarsTemplateEngine());


    }
}