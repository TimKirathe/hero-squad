package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class SquadTest {
    @Test
    void teamGetsReturnedSuccessfully() {
        Hero hero = new Hero("Jogn", 5674, "Immortal", "cats");
        Team team = new Team(hero);
        assertEquals(hero, team.getHero());
    }
}