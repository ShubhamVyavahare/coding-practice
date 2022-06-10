package scenariobased.demo13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Read text file and print the output using java 8
 */
public class demo13 {
    public static void main(String[] args) {
        Path path = Paths.get("src/scenariobased/demo13/HelloWorld.txt");
        try {
            List<String> stringList = Files.readAllLines(path);
            stringList.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
