package hu.nye.progtech.gamelogic;

import hu.nye.progtech.gamelogic.db.DatabaseLoader;
import hu.nye.progtech.models.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WumpusLogicTest {

    private WumpusLogic wumpusLogic;

    private DatabaseLoader loader;

    @BeforeEach
    public void setUp(){
        loader= new DatabaseLoader();
        wumpusLogic= new WumpusLogic(LoadFrom.file, 1, loader);
    }

    @Test
    void testGoStraightAheadShouldHerosRowDecrementWithOneValueWhenTheHerosDirectionIsNorth(){
        wumpusLogic.getHero().setDirection(Direction.North);
        wumpusLogic.getHero().setRow(5);
        wumpusLogic.getHero().setColumn('B');
        wumpusLogic.goStraightAhead();
        Assertions.assertEquals(4,wumpusLogic.getHero().getRow());
    }

    @Test
    void testGoStraightAheadShouldHerosRowIncrementWithOneValueWhenTheHerosDirectionIsSouth(){
        wumpusLogic.getHero().setDirection(Direction.South);
        wumpusLogic.getHero().setRow(4);
        wumpusLogic.getHero().setColumn('B');
        wumpusLogic.goStraightAhead();
        Assertions.assertEquals(5,wumpusLogic.getHero().getRow());
    }

    @Test
    void testGoStraightAheadShouldHerosColumnIncrementWithOneValueWhenTheHerosDirectionIsEast(){
        wumpusLogic.getHero().setDirection(Direction.East);
        wumpusLogic.getHero().setRow(3);
        wumpusLogic.getHero().setColumn('B');
        wumpusLogic.goStraightAhead();
        Assertions.assertEquals('C',wumpusLogic.getHero().getColumn());
    }

    @Test
    void testGoStraightAheadShouldHerosColumnDecrementWithOneValueWhenTheHerosDirectionIsWest(){
        wumpusLogic.getHero().setDirection(Direction.West);
        wumpusLogic.getHero().setRow(3);
        wumpusLogic.getHero().setColumn('C');
        wumpusLogic.goStraightAhead();
        Assertions.assertEquals('B',wumpusLogic.getHero().getColumn());
    }

    @Test
    void testShootWithArrowShouldDecrementTheHerosArrowsWhenIAmShooting(){
        wumpusLogic.getHero().setArrowCount(1);
        wumpusLogic.shootWithArrow();
        Assertions.assertEquals(0, wumpusLogic.getHero().getArrowCount());
    }

    @Test
    void testShootWithArrowShouldKillTheWumpusWhenIAmShootingAtThatDirection(){
        wumpusLogic.getHero().setArrowCount(1);

        wumpusLogic.getHero().setDirection(Direction.South);
        int row=0;
        char column='A';
        for(int i=0; i< wumpusLogic.field.size(); i++) {
            if(wumpusLogic.field.get(i).getShortCut()=='U'){
               row =  wumpusLogic.field.get(i).getRow();
               column = wumpusLogic.field.get(i).getColumn();
                break;
            }
        }
        wumpusLogic.getHero().setColumn(column);
        wumpusLogic.getHero().setRow(row-1);
        Assertions.assertEquals(true, wumpusLogic.shootWithArrow());
    }

    @Test
    void testShootWithArrowShouldKillTheWumpusWhenIAmShootingAtThatDirectionWest(){
        wumpusLogic.getHero().setArrowCount(1);

        wumpusLogic.getHero().setDirection(Direction.West);
        int row=0;
        char column='A';
        for(int i=0; i< wumpusLogic.field.size(); i++) {
            if(wumpusLogic.field.get(i).getShortCut()=='U'){
                row =  wumpusLogic.field.get(i).getRow();
                column = wumpusLogic.field.get(i).getColumn();
                break;
            }
        }
        wumpusLogic.getHero().setColumn((char) ((int)column+1));
        wumpusLogic.getHero().setRow(row);
        Assertions.assertEquals(true, wumpusLogic.shootWithArrow());
    }

    @Test
    void testShootWithArrowShouldKillTheWumpusWhenIAmShootingAtThatDirectionNorth(){
        wumpusLogic.getHero().setArrowCount(1);

        wumpusLogic.getHero().setDirection(Direction.North);
        int row=0;
        char column='A';
        for(int i=0; i< wumpusLogic.field.size(); i++) {
            if(wumpusLogic.field.get(i).getShortCut()=='U'){
                row =  wumpusLogic.field.get(i).getRow();
                column = wumpusLogic.field.get(i).getColumn();
                break;
            }
        }
        wumpusLogic.getHero().setColumn(column);
        wumpusLogic.getHero().setRow(row+1);
        Assertions.assertEquals(true, wumpusLogic.shootWithArrow());
    }

    @Test
    void testGoStraightAheadShouldNotifyWhenIAmASpecialPlaceWhereIsAGold() {
        wumpusLogic.getHero().setArrowCount(1);

        wumpusLogic.getHero().setDirection(Direction.South);
        int row=0;
        char column='A';
        for(int i=0; i< wumpusLogic.field.size(); i++) {
            if(wumpusLogic.field.get(i).getShortCut()=='G'){
                row =  wumpusLogic.field.get(i).getRow();
                column = wumpusLogic.field.get(i).getColumn();
                break;
            }
        }
        wumpusLogic.getHero().setColumn(column);
        wumpusLogic.getHero().setRow(row-1);

        Assertions.assertEquals("Jé! Itt van egy arany! Vedd fel!",wumpusLogic.goStraightAhead());
    }

    @Test
    void testWinStateCheckerShouldSetTheWinVariableToTrueWhenTheHeroDoesWin(){
        int row=0;
        char column='A';
        for(int i=0; i< wumpusLogic.field.size(); i++) {
            if(wumpusLogic.field.get(i).getShortCut()=='G'){
                row= wumpusLogic.field.get(i).getRow();
                column=wumpusLogic.field.get(i).getColumn();
                break;
            }
        }
        // ha ugyan azon a helyen van
        wumpusLogic.getHero().setColumn(column);
        wumpusLogic.getHero().setRow(row);
        wumpusLogic.takeTheGold(); // true
        wumpusLogic.getHero().setColumn( wumpusLogic.getHero().getStartColumn());
        wumpusLogic.getHero().setRow( wumpusLogic.getHero().getStartRow());
        Assertions.assertEquals(wumpusLogic.hero.isWinner(),true);
    }

    @Test
    void testTakeTheGoldShouldGiveThatWhenHeIsOnThatPlaceWhereTheGoldIs() {
        // Given
        int row=0;
        char column='A';
        for(int i=0; i< wumpusLogic.field.size(); i++) {
            if(wumpusLogic.field.get(i).getShortCut()=='G'){
                row= wumpusLogic.field.get(i).getRow();
                column=wumpusLogic.field.get(i).getColumn();
                break;
            }
        }
        // ha ugyan azon a helyen van
        wumpusLogic.getHero().setColumn(column);
        wumpusLogic.getHero().setRow(row);

        // WHEN
        boolean result = wumpusLogic.takeTheGold(); // true

        // THEN
        Assertions.assertEquals(result,wumpusLogic.getHero().hasGold());
    }

    @Test
    void testTakeTheGoldShouldDoNotGiveThatWhenHeIsNotOnThatPlaceWhereTheGoldIs() {
        // Given
        int row=0;
        char column='A';
        for(int i=0; i< wumpusLogic.field.size(); i++) {
            if(wumpusLogic.field.get(i).getShortCut()!='G'){
                row= wumpusLogic.field.get(i).getRow();
                column=wumpusLogic.field.get(i).getColumn();
                break;
            }
        }
        // ha ugyan azon a helyen van
        wumpusLogic.getHero().setColumn(column);
        wumpusLogic.getHero().setRow(row);

        // WHEN
        boolean result = wumpusLogic.takeTheGold(); // false

        // THEN
        Assertions.assertEquals(result,wumpusLogic.getHero().hasGold());
    }

    @Test
    void testGoStraightAheadShouldMoveHeroEastAndUpdateStepCounter() {
        // GIVEN
        int initialColumn = wumpusLogic.getHero().getColumn();
        int initialStepCounter = wumpusLogic.getHero().getStep();

        // WHEN
        String message = wumpusLogic.goStraightAhead();

        // THEN
        assertEquals("Csak így tovább!", message);
        assertEquals(initialColumn + 1, wumpusLogic.getHero().getColumn());
        assertEquals(initialStepCounter + 1, wumpusLogic.getHero().getStep());
    }

}