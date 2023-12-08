package hu.nye.progtech;

import hu.nye.progtech.gamelogic.WumpusLogic;
import hu.nye.progtech.gamelogic.db.DatabaseLoader;
import hu.nye.progtech.gamelogic.db.DbRepository;
import hu.nye.progtech.models.Hero;
import hu.nye.progtech.views.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void main(String[] args) {
        StartApp app = new StartApp();
        app.startApp();
    }


}