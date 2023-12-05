package hu.nye.progtech.gamelogic.db;

import java.util.List;

import hu.nye.progtech.models.Hero;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class DatabaseLoader {

    DbRepository dbRepository = new DbRepository();

    public Hero getHeroData(int id) {
        return dbRepository.getHeros().get(id);
    }

    public List<Hero> getHeroes() {
        return  dbRepository.getHeros();
    }

    public String deleteHero(int id) {
        return dbRepository.deleteHero(id);
    }

    public String saveHero(Hero hero) {
        return  dbRepository.insertHero(hero);
    }

    public String updateHero(Hero hero) {
        return  dbRepository.updateHero(hero);
    }
}
