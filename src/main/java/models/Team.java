package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {
    private List<Hero> team = Arrays.asList(new Hero[4]);

    public Team(Hero hero1, Hero hero2, Hero hero3, Hero hero4) {
        team.set(0, hero1);
        team.set(1, hero2);
        team.set(2, hero3);
        team.set(3, hero4);
    }

    public List<Hero> getTeam() {
        return team;
    }
}
