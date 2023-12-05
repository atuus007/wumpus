package hu.nye.progtech.gamelogic.db;

import hu.nye.progtech.models.Hero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseLoaderTest {
    private DatabaseLoader databaseLoader;

    @BeforeEach
    void setUp() {
        databaseLoader = new DatabaseLoader();
    }

    @Test
    void testGetHeroData() {
        // Előfeltétel: az adatbázisnak tartalmaznia kell legalább egy hőst
        Hero hero = databaseLoader.getHeroData(1);
        assertNotNull(hero);
    }

    @Test
    void testGetHeroes() {
        List<Hero> heroes = databaseLoader.getHeroes();
        assertNotNull(heroes);
        assertTrue(heroes.size() > 0);
    }

    @Test
    void testDeleteHero() {
        // Előfeltétel: az adatbázisnak tartalmaznia kell legalább egy hőst
        String result = databaseLoader.deleteHero(1);
        assertNotNull(result);
        assertEquals("A hős sikeresen törölve.", result);
    }

    @Test
    void testSaveHero() {
        Hero newHero = new Hero(/*...*/); // Új hős példány létrehozása
        String result = databaseLoader.saveHero(newHero);
        assertNotNull(result);
        assertEquals("A hős sikeresen rögzítve.", result);
    }

    @Test
    void testUpdateHero() {
        // Előfeltétel: az adatbázisnak tartalmaznia kell legalább egy hőst
        Hero existingHero = databaseLoader.getHeroData(1);
        existingHero.setName("UpdatedName"); // Például név módosítása
        String result = databaseLoader.updateHero(existingHero);
        assertNotNull(result);
        assertEquals("A hős sikeresen frissítve.", result);
    }
}