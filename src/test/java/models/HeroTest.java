package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void heroGetsInstantiatedCorrectly() {
        Hero hero = new Hero("john", 23, "super strength", "water");
        assertTrue(hero instanceof  Hero);
    }
}