package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void heroTeamGetsReturned() {
        Hero hero1 = new Hero("john", 23, "super strength", "water");
        Hero hero2 = new Hero("james", 34, "invincible", "none");
        Hero hero3 = new Hero("rodgers", 13, "Control the weather", "Outer space");
        Hero hero4 = new Hero("Sean", 45, "Heat vision", "extreme heat");
        Team team = new Team("Supa Strikers", "Villains", hero1, hero2, hero3, hero4);
        assertTrue(team instanceof Team);
    }
}