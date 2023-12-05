package hu.nye.progtech.gamelogic;

import hu.nye.progtech.models.FieldObject;
import hu.nye.progtech.models.Hero;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileLoaderTest {
    @Test
    void testFileLoaderInitialization() {
        FileLoader fileLoader = new FileLoader();

        assertNotNull(fileLoader.getHero());
        assertNotNull(fileLoader.getField());
        assertTrue(fileLoader.getMatrixLength() > 0);
    }

    @Test
    void testFileLoaderHeroData() {
        FileLoader fileLoader = new FileLoader();
        Hero hero = fileLoader.getHero();

        assertNotNull(hero);
        assertTrue(hero.getColumn() >= 'A' && hero.getColumn() <= 'Z');
        assertTrue(hero.getRow() > 0);
        assertNotNull(hero.getDirection());
        assertTrue(hero.getArrowCount() >= 0);
        assertNotNull(hero.getName());
        assertTrue(hero.getStep() >= 0);
        assertTrue(hero.getMatrixLength() > 0);
    }

    @Test
    void testFileLoaderFieldData() {
        FileLoader fileLoader = new FileLoader();
        List<FieldObject> fields = fileLoader.getField();

        assertNotNull(fields);
        assertTrue(fields.size() > 0);

        for (FieldObject field : fields) {
            assertNotNull(field.getShortCut());
            assertTrue(field.getColumn() >= 'A' && field.getColumn() <= 'Z');
            assertTrue(field.getRow() > 0);
            assertEquals(-1, field.getUserID()); // mert a konstruktorban -1-t állítunk be
            assertTrue(field.getMatrixLength() > 0);
        }
    }

    @Test
    void testFileLoaderMatrixLength() {
        FileLoader fileLoader = new FileLoader();
        int matrixLength = fileLoader.getMatrixLength();

        assertTrue(matrixLength > 0);
    }
}