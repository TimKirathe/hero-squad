import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

import java.util.Map;

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

        post("/posts/team", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("teamName");
            String cause = request.queryParams("cause");
            Integer heroId1 = Integer.parseInt(request.queryParams("hero1"));
            Integer heroId2 = Integer.parseInt(request.queryParams("hero2"));
            Integer heroId3 = Integer.parseInt(request.queryParams("hero3"));
            Integer heroId4 = Integer.parseInt(request.queryParams("hero4"));
            Hero hero1 = Hero.getById(heroId1);
            Hero hero2 = Hero.getById(heroId2);
            Hero hero3 = Hero.getById(heroId3);
            Hero hero4 = Hero.getById(heroId4);
            ArrayList<Hero> chosenHeros = new ArrayList<>();
            chosenHeros.add(hero1);
            chosenHeros.add(hero2);
            chosenHeros.add(hero3);
            chosenHeros.add(hero4);
            Team team = new Team(name, cause, hero1, hero2, hero3, hero4);
            ArrayList<Team> teams = new ArrayList<>();
            teams.add(team);
            model.put("teams", teams);
            model.put("chosenHeros", chosenHeros);
            return new ModelAndView(model, "squad-view.hbs");
        }, new HandlebarsTemplateEngine());
    }
}