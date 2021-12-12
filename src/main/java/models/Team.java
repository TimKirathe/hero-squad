package models;

import models.Hero;
import java.util.ArrayList;

public class Team {
    private Hero hero;
    private ArrayList<Hero> team = new ArrayList<>();

    public Team(Hero hero) {
        this.hero = hero;
        team.add(hero);
    }

    public Hero getHero() {
        return hero;
    }


}
