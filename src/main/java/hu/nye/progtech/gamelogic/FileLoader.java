package hu.nye.progtech.gamelogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import hu.nye.progtech.enums.Direction;
import hu.nye.progtech.models.FieldObject;
import hu.nye.progtech.models.Hero;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class FileLoader {

    private static final String FILENAME = "wumpuszinput.txt";
    private Hero hero;

    List<FieldObject> fields = new ArrayList<>();
    int matrixLength = 0;

    public FileLoader() {
        this.initPlayerFieldFromFile();
    }

    private void initPlayerFieldFromFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(FILENAME);

        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)
        ) {
            String line;
            String[] firstLine = reader.readLine().split(" ");
            matrixLength = Integer.parseInt(firstLine[0]);
            int row = 1;

            while ((line = reader.readLine()) != null) {
                String[] currentLine = line.split("");
                for(int column = 0; column<currentLine.length; column++){
                    fields.add(
                        new FieldObject(
                            currentLine[column].charAt(0),
                            (char) (column + 65), // mert az A-->65ös indexű az ASCII-ben
                            row,
                            -1,
                            matrixLength
                        )
                    );
                }
                row++;
            }
            // hős adatainak a betöltése
            this.hero = createHero(firstLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Hero createHero(String[] firstLineData) {

        return new Hero(
            -1,  //id
            firstLineData[1].charAt(0),
            Integer.parseInt(firstLineData[2]),
            this.getCorrectDirection(firstLineData[3].charAt(0)),
            this.numberOfWumpus(), //azért mert annyi nyillal kezd amennyi wumpus van
            "unknow",
            0,
            firstLineData[1].charAt(0),
            Integer.parseInt(firstLineData[2]),
            false,
            matrixLength
        );


    }
    public Hero getHero() {
        return hero;
    }

    public List<FieldObject> getField() {
        return fields;
    }

    public int getMatrixLength() {
        return  matrixLength;
    }
    private int numberOfWumpus() {
        return (int) fields.stream()
                .map(FieldObject::getShortCut) // Csak az első karaktert nézzük
                .filter(c -> c == 'U')
                .count();
    }

    private Direction getCorrectDirection(char  direction) {
        return Direction.getDirectionFromChar(direction);
    }


}
