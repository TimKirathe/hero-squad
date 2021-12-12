package models;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void heroGetsInstantiatedCorrectly() {
        Hero hero = new Hero("john", 23, "super strength", "water");
        assertTrue(hero instanceof  Hero);
    }

    @Test
    void allHeroInstancesGetReturnedSuccessfully() {
        Hero hero = new Hero("john", 23, "super strength", "water");
        Hero hero1 = new Hero("james", 34, "invincible", "none");
        assertEquals(2, Hero.getAll().size());
    }

    @Test
    void teamOfHerosGetsCreatedAndReturned() {
        Hero hero1 = new Hero("john", 23, "super strength", "water");
        Hero hero2 = new Hero("james", 34, "invincible", "none");
        Hero hero3 = new Hero("rodgers", 13, "Control the weather", "Outer space");
        Hero hero4 = new Hero("Sean", 45, "Heat vision", "extreme heat");
        List<Hero> team = Arrays.asList(new Hero[4]);
        team.set(0, hero1);
        team.set(1, hero2);
        team.set(2, hero3);
        team.set(3, hero4);
        assertEquals(true, team.size() == 4);

    }
}