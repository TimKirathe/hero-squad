package models;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {
    private List<Hero> team = Arrays.asList(new Hero[4]);
    private String name;
    private String cause;
    private static ArrayList<Team> instances = new ArrayList<>();

    public Team(String name, String cause, Hero hero1, Hero hero2, Hero hero3, Hero hero4) {
        this.name = name;
        this.cause = cause;
        team.set(0, hero1);
        team.set(1, hero2);
        team.set(2, hero3);
        team.set(3, hero4);
        instances.add(this);
    }

    public List<Hero> getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public String getCause() {
        return cause;
    }

    public static ArrayList<Team> getInstances() {
        return instances;
    }

}
