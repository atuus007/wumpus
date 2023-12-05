package hu.nye.progtech.gamelogic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import hu.nye.progtech.models.Direction;
import hu.nye.progtech.models.FieldObject;
import hu.nye.progtech.models.Hero;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class FileLoader {


    public Hero getHero() {
        return hero;
    }

    public List<FieldObject> getField() {
        return fields;
    }

    public int getMatrixLength() {
        return  matrixLength;
    }

    Hero hero = new Hero();

    List<FieldObject> fields = new ArrayList<>();
    int matrixLength = 0;

    public FileLoader() {
        Path projectDirectory = Paths.get(System.getProperty("user.dir"));
        Path relativePath = Paths.get("src", "main", "java", "hu", "nye", "progtech", "data", "wumpuszinput.txt");
        Path fullPath = projectDirectory.resolve(relativePath);
        try {
            String content = Files.readString(fullPath);
            String[] splitLine = content.split("\n");
            if (splitLine.length > 0) {
                // A mátrix n értéke
                String[] firstLine = splitLine[0].split(" ");
                matrixLength = Integer.parseInt(firstLine[0]);



                // pálya betölése
                for (int row = 1; row <= matrixLength; row++) {
                    for (int column = 0; column < matrixLength; column++) {
                        fields.add(new FieldObject(
                                splitLine[row].charAt(column),
                                (char) (column + 65), // mert az A-->65ös indexű az ASCII-ben
                                row,
                                -1,
                                matrixLength
                        ));
                    }
                }
                // hős adatainak a betöltése
                hero = new Hero(
                        -1,
                        'H',
                        firstLine[1].charAt(0),
                        Integer.parseInt(firstLine[2]),
                        getCorrectDirection(firstLine[3].charAt(0)),
                        numberOfWumpus(), //azért mert annyi nyillal kezd amennyi wumpus van
                        "unknow", hero.getStep(), firstLine[1].charAt(0),
                        Integer.parseInt(firstLine[2]), false, matrixLength);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int numberOfWumpus() {
        return (int) fields.stream()
                .map(FieldObject::getShortCut) // Csak az első karaktert nézzük
                .filter(c -> c == 'U')
                .count();
    }

    private Direction getCorrectDirection(char  direction) {
        return switch (direction) {
            case 'N' -> Direction.North;
            case 'W' -> Direction.West;
            case 'S' -> Direction.South;
            default -> Direction.East;
        };
    }


}
