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
}